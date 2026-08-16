#!/bin/bash

# ==========================================
# CONFIGURATION & MATRIX ARRAY
# ==========================================
PROMPT_FILE="prompts/23-v2-The-Pacific-in-Transition.md"
OUT_DIR="results/Logistics-and-Strategy-v2"
OUT_PREFIX="23-v2-The-Pacific-in-Transition"
# Exact OpenRouter active network slug identities
MODELS=(
    "anthropic/claude-4.8-opus-20260528"
    "moonshotai/kimi-k2-thinking"
    "deepseek/deepseek-v4-flash-0731"
    "openai/gpt-5.6-sol"
)

# ==========================================
# KEY RESOLUTION & PRE-FLIGHT
# ==========================================
if [ -z "$OPENROUTER_API_KEY" ] && [ -f .env ]; then
    export $(grep -v '^#' .env | xargs)
fi

if [ -z "$OPENROUTER_API_KEY" ]; then
    echo "❌ Error: OPENROUTER_API_KEY is not set globally or in a .env file."
    exit 1
fi

if [ ! -f "$PROMPT_FILE" ]; then
    echo "❌ Error: Prompt resource file '$PROMPT_FILE' missing."
    exit 1
fi

echo "📋 Found target prompt. Initializing multi-model evaluation loop..."
echo "------------------------------------------------------------------"

# Read prompt context safely using jq's raw file input string filter
# This isolates any complex LaTeX slashes or math variables securely
PROMPT_TEXT=$(jq -Rs . "$PROMPT_FILE")

# ==========================================
# MATRIX EXECUTION LOOP
# ==========================================
for CURRENT_MODEL in "${MODELS[@]}"; do
    SAFE_MODEL_NAME=$(echo "$CURRENT_MODEL" | tr '/' '-')
    OUT_FILE="${OUT_DIR}/${OUT_PREFIX}-${SAFE_MODEL_NAME}-v1.md"
    
    mkdir -p "$OUT_DIR"
    
    echo -e "\n🤖 Starting Model Sequence: $CURRENT_MODEL"
    echo "📂 Output Destination: $OUT_FILE"
    
    # 100% safe nested JSON composition block
    JSON_PAYLOAD=$(jq -n \
      --arg model "$CURRENT_MODEL" \
      --argjson prompt "$PROMPT_TEXT" \
      '{model: $model, messages: [{role: "user", content: $prompt}]}')
      
    TMP_RESPONSE=$(mktemp)
    
    # Fire off network request and preserve the server's HTTP response status code
    HTTP_STATUS=$(curl -s -o "$TMP_RESPONSE" -w "%{http_code}" -X POST https://openrouter.ai/api/v1/chat/completions \
      -H "Content-Type: application/json" \
      -H "Authorization: Bearer $OPENROUTER_API_KEY" \
      -d "$JSON_PAYLOAD")
      
    echo "✅ Server handshake complete (HTTP Status: $HTTP_STATUS)"
    
    # Diagnostic 1: Catch network request errors immediately
    if [ "$HTTP_STATUS" -ne 200 ]; then
        echo "❌ Network Error (Status $HTTP_STATUS). Server raw feedback output:"
        cat "$TMP_RESPONSE"
        rm -f "$TMP_RESPONSE"
        continue
    fi
    
    # Diagnostic 2: Verify structural JSON layout integrity
    if ! jq . "$TMP_RESPONSE" >/dev/null 2>&1; then
        echo "❌ Data Error: Non-JSON layout structure received."
        cat "$TMP_RESPONSE" >> "$OUT_FILE"
        rm -f "$TMP_RESPONSE"
        continue
    fi
    
    # Diagnostic 3: Catch localized upstream model provider structural faults
    if jq -e '.error' "$TMP_RESPONSE" >/dev/null 2>&1; then
        ERROR_MSG=$(jq -r '.error.message' "$TMP_RESPONSE")
        echo "❌ OpenRouter API Exclusion: $ERROR_MSG"
        rm -f "$TMP_RESPONSE"
        continue
    fi
    
    # Extract structural content streams securely to Markdown target locations
    jq -r '"Cost: \(.usage.cost // "N/A")\n\n\(.choices[0].message.content)"' "$TMP_RESPONSE" > "$OUT_FILE"
    
    echo "🎉 Success! Target document saved."
    rm -f "$TMP_RESPONSE"
done

echo "------------------------------------------------------------------"
echo "🏁 Matrix complete! Files saved to '$OUT_DIR'."

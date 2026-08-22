#!/bin/bash

# ==========================================
# CONFIGURATION
# ==========================================
# Default model slug identity from OpenRouter (stealth/ox-alpha)
DEFAULT_MODEL="stealth/ox-alpha"
MODEL="${1:-$DEFAULT_MODEL}"
PROMPTS_DIR="prompts"
OUT_DIR="results/Logistics-and-Strategy-v2"

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

if [ ! -d "$PROMPTS_DIR" ]; then
    echo "❌ Error: Prompts directory '$PROMPTS_DIR' is missing."
    exit 1
fi

SAFE_MODEL_NAME=$(echo "$MODEL" | tr '/' '-')

echo "📋 Initializing single-model multi-prompt evaluation loop..."
echo "🤖 Target Model:     $MODEL"
echo "📂 Output Directory:  $OUT_DIR"
echo "------------------------------------------------------------------"

# ==========================================
# EXECUTION LOOP OVER ALL PROMPTS
# ==========================================
# Alphabetic expansion ensures prompts 01 through 32 are executed sequentially
for PROMPT_FILE in "$PROMPTS_DIR"/*.md; do
    [ -e "$PROMPT_FILE" ] || continue
    
    BASE_NAME=$(basename "$PROMPT_FILE" .md)
    OUT_FILE="${OUT_DIR}/${BASE_NAME}-${SAFE_MODEL_NAME}-v1.md"
    
    mkdir -p "$OUT_DIR"
    
    echo -e "\n📝 Processing Prompt: $BASE_NAME"
    echo "📂 Output Destination: $OUT_FILE"
    
    # Read prompt context safely using jq's raw file input string filter
    # This isolates any complex LaTeX slashes or math variables securely
    PROMPT_TEXT=$(jq -Rs . "$PROMPT_FILE")
    
    # 100% safe nested JSON composition block
    JSON_PAYLOAD=$(jq -n \
      --arg model "$MODEL" \
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
echo "🏁 Single-model evaluation complete! Files saved to '$OUT_DIR'."

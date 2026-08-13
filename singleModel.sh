#!/bin/bash

# ==========================================
# CONFIGURATION
# ==========================================
MODEL="deepseek/deepseek-v4-flash-0731"
PROMPT_FILE="../prompts/04-Integration.md"
OUT_DIR="results/CalculusAndAnalyticGeometry"
OUT_PREFIX="04-Integration"

# ==========================================
# KEY RESOLUTION
# ==========================================
if [ -z "$OPENROUTER_API_KEY" ] && [ -f .env ]; then
    export $(grep -v '^#' .env | xargs)
fi

if [ -z "$OPENROUTER_API_KEY" ]; then
    echo "❌ Error: OPENROUTER_API_KEY is not set globally or in a .env file."
    echo "Please run: export OPENROUTER_API_KEY=\"your_key_here\""
    exit 1
fi

# ==========================================
# SAFETY CHECKS & FILE NAMING
# ==========================================
if [ ! -f "$PROMPT_FILE" ]; then
    echo "❌ Error: $PROMPT_FILE not found!"
    exit 1
fi

SAFE_MODEL_NAME=$(echo "$MODEL" | tr '/' '-')

OUT_FILE="${OUT_DIR}/${OUT_PREFIX}-${SAFE_MODEL_NAME}.v2.md"
mkdir -p "$OUT_DIR"

# ==========================================
# JSON PAYLOAD GENERATION (STREAMING DISABLED)
# ==========================================
# Removed stream parameter entirely to request a single payload contract block
JSON_PAYLOAD=$(jq -n \
  --arg model "$MODEL" \
  --arg prompt "$(cat "$PROMPT_FILE")" \
  '{model: $model, messages: [{role: "user", content: $prompt}]}')

# ==========================================
# BACKGROUND EXECUTION & TICKER
# ==========================================
echo "🚀 Running evaluation..."
echo "🤖 Model:  $MODEL"
echo "📂 Output: $OUT_FILE"
echo "--------------------------------------------"

# Spin up a localized temp holding point for the single frame response
TMP_RESPONSE=$(mktemp)

# Dispatch the raw blocking network request into an isolated background thread
curl -s -X POST https://openrouter.ai/api/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENROUTER_API_KEY" \
  -d "$JSON_PAYLOAD" > "$TMP_RESPONSE" &

CURL_PID=$!

# Dynamic ticker loop providing visible signs of life while waiting for the model
SPINNER_FRAME="/-\|"
SECONDS_ELAPSED=0

echo -n "⏳ Thinking... "
while kill -0 $CURL_PID 2>/dev/null; do
    for i in {0..3}; do
        # Print current spinner tick alongside total wall time tracking
        echo -ne "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"
        echo -ne "⏳ [${SECONDS_ELAPSED}s] Processing ${SPINNER_FRAME:$i:1}"
        sleep 0.25
    done
    ((SECONDS_ELAPSED++))
done

# Wipe clean trace markers
echo -ne "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"
echo "✅ Response JSON received in ${SECONDS_ELAPSED}s!"

# ==========================================
# DIAGNOSTICS & EXTRACTION
# ==========================================
# Guard: Check if the response received is valid JSON
if ! jq . "$TMP_RESPONSE" >/dev/null 2>&1; then
    echo "❌ Error: Server returned an invalid response structure (Non-JSON)."
    echo "Raw response summary:"
    cat "$TMP_RESPONSE"
    rm -f "$TMP_RESPONSE"
    exit 1
fi

# Guard: Check if OpenRouter passed a platform level rejection error block
if jq -e '.error' "$TMP_RESPONSE" >/dev/null 2>&1; then
    ERROR_MSG=$(jq -r '.error.message' "$TMP_RESPONSE")
    ERROR_CODE=$(jq -r '.error.code // "N/A"' "$TMP_RESPONSE")
    echo "❌ OpenRouter API Error: $ERROR_MSG (Code: $ERROR_CODE)"
    rm -f "$TMP_RESPONSE"
    exit 1
fi

# ==========================================
# OUTPUT PROCESSING
# ==========================================
# Extract the structured completion tokens and route them to markdown
jq -r '"Cost: \(.usage.cost // "N/A")\n\n\(.choices[0].message.content)"' "$TMP_RESPONSE" > "$OUT_FILE"

# Display a preview of the response in the terminal
echo -e "\n--- File Preview ---"
head -n 15 "$OUT_FILE"
echo -e "...\n--------------------"

# Cleanup memory mapping
rm -f "$TMP_RESPONSE"

echo "🎉 Done! Output file successfully updated."

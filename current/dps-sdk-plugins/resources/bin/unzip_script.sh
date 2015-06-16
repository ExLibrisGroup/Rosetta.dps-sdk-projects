#!/bin/csh

set OUTPUT_DIR="$1"
set FILE_NAME="$2"

unzip -o -P aaaa -d "$OUTPUT_DIR" "$FILE_NAME"

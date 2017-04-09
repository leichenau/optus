#!/bin/bash
if [[ "$#" -ne 3 ]]; then
    echo "Please provide input file, property file and output file"
    exit
fi

template_file="$1"
property_file="$2"
output_file="$3"

template_content=$(<$template_file)

if [[ -f "$property_file" ]]
then
while IFS='=' read -r key value
  do
    key=$(echo $key | tr '.' '_')
    eval "${key}='${value}'"
    
    template_content="${template_content/\[\[$key\]\]/$value}"
   
  done < "$property_file"
  echo "$template_content" > "$output_file"
else
    echo "can not read property file"
fi

echo "Done!"



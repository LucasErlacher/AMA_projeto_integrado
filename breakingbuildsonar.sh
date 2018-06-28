#!/bin/bash
#sh buildbreaksonar.sh sonar.txt c8fa3ca2a1b63fd4209ad71670e16d612daa416e (token) https://sonarcloud.io

echo "Starting Scrip"

echo "Searching SonnarQueb AnalysisId in $1" 
    
url=$(grep "/api/ce/task?id=" $1 | sed s/.*h// )

echo "Searching at h$url"

curl -u $2: "h$url"

analysisId=$(curl -u $2: "h$url" | jq -r '.task.analysisId')

echo "AnalysisID: $analysisId"

echo "Searching at $3/api/qualitygates/project_status?analysisId=$analysisId"
    
status=$(curl -u $2: "$3/api/qualitygates/project_status?analysisId=$analysisId" | jq -r '.projectStatus.status')

echo "Status: $status" 

if [ $status = "ERROR" ]; then 
    echo "ERROR";exit 1;
else
    echo "OK";exit 0;    
fi

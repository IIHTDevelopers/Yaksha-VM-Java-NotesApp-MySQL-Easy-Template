#!/bin/bash

# Source the required files to import the functions
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

source "$SCRIPT_DIR/testCaseResult.sh"
source "$SCRIPT_DIR/testResults.sh"

# Constants for URL and GUID
URL="https://yaksha-prod-sbfn.azurewebsites.net/api/YakshaMFAEnqueue?code=jSTWTxtQ8kZgQ5FC0oLgoSgZG7UoU9Asnmxgp6hLLvYId/GW9ccoLw=="
# URL="https://jsonplaceholder.typicode.com/todos/1"
GUID="6ed39465-d6d3-4ec4-b27d-1dcb870b2992"

declare -A testCaseResultsMap

# createTestUtils() {
#     local customData="$1"

#     # Create a testCaseResult using createTestCaseResult function from testCaseResult.sh
#     local testCaseResult=$(createTestCaseResult "method1" "GET" 80 75 "PASS" true "No errors")

#     # Create a testResults object using createTestResults function from testResults.sh
#     local testResultsObject=$(createTestResults "$testCaseResult" "$customData")

#     # echo "$testResultsObject"
# }

# Function to read the data from a file
# readCustomFileData() {
#     local filePath="$1"
#     local customData=$(cat "$filePath")
#     # echo "$customData"
# }
readCustomFileData() {
    local parent_folder="../../"
    local file_path="$parent_folder""custom.ih"

    # Check if the file exists
    if [ -f "$file_path" ]; then
        # Read the content of the file and store it in the 'customData' variable
        customData=$(<"$file_path")
        echo "$customData"
    else
        echo "Error: 'custom.ih' file not found in the parent folder."
        exit 1
    fi
}

# Function to perform the Yaksha assertion
yakshaAssert() {
    local testName="$1"
    local result="$2"
    local testType="$3"

    # Get customData from the file "../custom.ih"
    ls -p | grep -v /
    # local customData=$(readCustomFileData "custom.ih")
    customData=$(readCustomFileData)
    echo "customData:- $customData"

    # Determine result status and score
    local resultStatus="Failed"
    local resultScore=0
    if [ "$result" -eq 1 ]; then
        resultScore=1
        resultStatus="Passed"
    fi

    local testTypeB="functional"

    # Initialize TestResults and TestCaseResults objects as JSON-like strings
    # Create a new TestCaseResult object and add it to the testCaseResults object
    
    # local testCaseResultObject=$(createTestCaseResult "$testName" "$testType" 1 "$resultScore" "$resultStatus" true "")
    # echo "testCaseResultObject:- $testCaseResultObject"
    testCaseResultObject=$(createTestCaseResult "$testName" "$testType" 1 "$resultScore" "$resultStatus" true "")
    
    # Add the testCaseResultObject to the testCaseResultsMap with GUID as the key
    testCaseResultsMap["$GUID"]="$testCaseResultObject"

    # Example to access the testCaseResultObject from the map using GUID as the key
    # echo "testCaseResultsMap: $testCaseResultsMap"



    testCaseResults=$(convertMapToJson)

    # Output the JSON representation of the testCaseResultsMap
    # echo "JSON representation of testCaseResultsMap:"
    # echo "$testCaseResults"



    # local testResults=$(createTestResults "$testCaseResultObject" "$GUID")
    local testResults=$(createTestResults "$testCaseResults" "$customData")
    # echo "testResults:- $testResults"

    # testCaseResults=$(setAttribute "$testCaseResults" "$GUID" $(createTestCaseResult "$testName" "$testType" 1 "$resultScore" "$resultStatus" true ""))    
    
    # local testCaseResults="{}"

    # # Set testCaseResults in testResults object
    # testResults=$(setAttribute "$testResults" "testCaseResults" "$testCaseResults")

    # # Set customData in testResults object
    # testResults=$(setAttribute "$testResults" "customData" "$customData")


    # result
    # echo $testResults

    # Request data in JSON format
    request_data=$testResults
    echo "request_data:- $request_data"

    # Set the headers and make the POST request using curl
    response=$(curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d "$request_data" "$URL")

    # Output the response
    echo "Response: $response"
}

# Function to convert testCaseResultsMap to JSON
convertMapToJson() {
    local json="{"
    local first_iteration=true

    for key in "${!testCaseResultsMap[@]}"; do
        if [ "$first_iteration" = false ]; then
            json+=","  # Add comma separator for all entries except the first
        fi
        json+="\"$key\": ${testCaseResultsMap[$key]}"
        first_iteration=false
    done

    json+="}"
    echo "$json"
}

# Example usage:

# # Create a TestUtils object
# testUtilsObject=$(createTestUtils "Custom data for test")

# # Get the value of the 'testCaseResults' attribute
# testCaseResults=$(getAttribute "$testUtilsObject" "testCaseResults")
# echo "Test Case Results: $testCaseResults"

# # Read data from a custom file (e.g., ../custom.ih)
# customFilePath="../custom.ih"
# customData=$(readCustomFileData "$customFilePath")
# echo "Custom Data from File: $customData"

# # name of test case
# testName="shoud have user with id 1"
# # either 1 or 0
# result=1
# # boundary/functional/exception
# testType="boundary"
# yakshaAssert "$testName" "$result" "$testType"

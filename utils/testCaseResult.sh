#!/bin/bash

# Function to create a new TestCaseResult object
# createTestCaseResult() {
#     local methodName="$1"
#     local methodType="$2"
#     local actualScore="$3"
#     local earnedScore="$4"
#     local status="$5"
#     local isMandatory="$6"
#     local errorMessage="$7"

#     # echo "{\"methodName\":\"$methodName\",\"methodType\":\"$methodType\",\"actualScore\":$actualScore,\"earnedScore\":$earnedScore,\"status\":\"$status\",\"isMandatory\":$isMandatory,\"errorMessage\":\"$errorMessage\"}"
# }

# Function to create a new TestCaseResult object
createTestCaseResult() {
    local methodName="$1"
    local methodType="$2"
    local actualScore="$3"
    local earnedScore="$4"
    local status="$5"
    local isMandatory="$6"
    local errorMessage="$7"

    # Create the JSON string for the TestCaseResult object
    local testCaseResultJSON="{\"methodName\":\"$methodName\",\"methodType\":\"$methodType\",\"actualScore\":$actualScore,\"earnedScore\":$earnedScore,\"status\":\"$status\",\"isMandatory\":$isMandatory,\"errorMessage\":\"$errorMessage\"}"

    echo "$testCaseResultJSON"
}


getAttribute() {
    local obj="$1"
    local attribute="$2"
    local value=$(echo "$obj" | grep -o "\"$attribute\":[^,]*" | cut -d":" -f2 | tr -d "\"")
    # echo "$value" | tr -d "\""
}

setAttribute() {
    local obj="$1"
    local attribute="$2"
    local value="$3"
    local updatedObj=$(echo "$obj" | sed "s/\"$attribute\":[^,]*/\"$attribute\":\"$value\"/")
    # echo "$updatedObj"
}

# # Example usage:
# testCaseResultObject=$(createTestCaseResult "method1" "GET" 80 75 "PASS" true "No errors")

# # Set the value of the 'actualScore' attribute
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "methodName" "90asd")
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "methodType" "POST")
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "actualScore" 500)
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "earnedScore" 100)
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "status" "fail")
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "isMandatory" false)
# testCaseResultObject=$(setAttribute "$testCaseResultObject" "errorMessage" "lots of errors")

# methodName=$(getAttribute "$testCaseResultObject" "methodName")
# echo "Method Name: $methodName" # Output: Method Name: method1
# methodType=$(getAttribute "$testCaseResultObject" "methodType")
# echo "Method Name: $methodType" # Output: Method Name: method1
# actualScore=$(getAttribute "$testCaseResultObject" "actualScore")
# echo "actualScore: $actualScore" # Output: Method Name: method1
# earnedScore=$(getAttribute "$testCaseResultObject" "earnedScore")
# echo "earnedScore: $earnedScore" # Output: Method Name: method1
# status=$(getAttribute "$testCaseResultObject" "status")
# echo "status: $status" # Output: Method Name: method1
# isMandatory=$(getAttribute "$testCaseResultObject" "isMandatory")
# echo "isMandatory: $isMandatory" # Output: Method Name: method1
# errorMessage=$(getAttribute "$testCaseResultObject" "errorMessage")
# echo "errorMessage: $errorMessage" # Output: Method Name: method1

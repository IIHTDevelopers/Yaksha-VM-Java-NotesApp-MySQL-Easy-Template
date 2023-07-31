#!/bin/bash

# Source the testCaseResult.sh file to import the functions
# source "testCaseResult.sh"

createTestResults() {
    local testCaseResults="$1"
    local customData="$2"

    # Create the JSON string for the TestResults object
    local testResultsJSON="{\"testCaseResults\":$testCaseResults,\"customData\":\"$customData\"}"

    echo "$testResultsJSON"
}

# Function to get the value of an attribute from the TestResults object
getAttribute() {
    local obj="$1"
    local attribute="$2"
    local value=$(echo "$obj" | grep -o "\"$attribute\":\"[^\"]*\"" | cut -d":" -f2 | tr -d "\"")
    # echo "$value"
}

# Function to set the value of an attribute in the TestResults object
setAttribute() {
    local obj="$1"
    local attribute="$2"
    local value="$3"
    local updatedObj=$(echo "$obj" | sed "s/\"$attribute\":\"[^\"]*\"/\"$attribute\":\"$value\"/")
    # echo "$updatedObj"
}

# Example usage:

# Create a testCaseResult using createTestCaseResult function from testCaseResult.sh
# testCaseResult=$(createTestCaseResult "method1" "GET" 80 75 "PASS" true "No errors")

# # Create a testResults object using createTestResults function
# testResultsObject=$(createTestResults "$testCaseResult" "Custom data for result 1")
# echo $testResultsObject

# # Get the value of the 'testCaseResults' attribute
# testCaseResults=$(getAttribute "$testResultsObject" "testCaseResults")
# echo "Test Case Results: $testCaseResults"

# # Set the value of the 'customData' attribute
# testResultsObject=$(setAttribute "$testResultsObject" "customData" "Updated custom data")

# # Get the updated value of the 'customData' attribute
# customData=$(getAttribute "$testResultsObject" "customData")
# echo "Updated Custom Data: $customData"






# #!/bin/bash

# source "testCaseResult.sh"

# # Function to create a new TestResults object
# createTestResults() {
#     local testCaseResults="$1"
#     local customData="$2"
#     echo "{\"testCaseResults\":$testCaseResults,\"customData\":\"$customData\"}"
# }

# # Function to get the value of an attribute from the TestResults object
# getAttribute() {
#     local obj="$1"
#     local attribute="$2"
#     local value=$(echo "$obj" | grep -o "\"$attribute\":\"[^\"]*\"" | cut -d":" -f2 | tr -d "\"")
#     echo "$value"
# }

# # Function to set the value of an attribute in the TestResults object
# setAttribute() {
#     local obj="$1"
#     local attribute="$2"
#     local value="$3"
#     local updatedObj=$(echo "$obj" | sed "s/\"$attribute\":\"[^\"]*\"/\"$attribute\":\"$value\"/")
#     echo "$updatedObj"
# }

# # Example usage:
# testCaseResultsData="{\"method\":\"method1\",\"score\":80,\"status\":\"PASS\"}"
# testResultsObject=$(createTestResults "$testCaseResultsData" "asdadasdasd")

# echo $testResultsObject

# # Get the value of the 'testCaseResults' attribute
# # testCaseResults=$(getAttribute "$testResultsObject" "testCaseResults")
# # echo "Test Case Results: $testCaseResults" # Output: Test Case Results: {"method":"method1","score":80,"status":"PASS"}

# # # Set the value of the 'customData' attribute
# # testResultsObject=$(setAttribute "$testResultsObject" "customData" "Updated custom data")

# # # Get the updated value of the 'customData' attribute
# # customData=$(getAttribute "$testResultsObject" "customData")
# # echo "Updated Custom Data: $customData" # Output: Updated Custom Data: Updated custom data

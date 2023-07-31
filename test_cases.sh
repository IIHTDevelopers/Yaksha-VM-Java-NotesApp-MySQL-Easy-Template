#!/bin/bash

# Source the required files to import the functions
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# echo $SCRIPT_DIR
source "$SCRIPT_DIR/utils/testCaseResult.sh"
source "$SCRIPT_DIR/utils/testResults.sh"
source "$SCRIPT_DIR/utils/testUtils.sh"

# Test case 1
# testUtilsObject=$(createTestUtils "Custom data for test1")
yakshaAssert "shoud have user with id 1" 1 "functional"

# Test case 2
# testUtilsObject=$(createTestUtils "Custom data for test2")
yakshaAssert "shoud have user with id 2" 0 "boundary"

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:OPI.feature");
formatter.feature({
  "name": "To verify the Ranking fields in overall postion indicator with source data",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Getting the College Ranking field from the Overall Position Indicator and compare with the source Test Data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OPIcollege"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enters the valid credentials and clicks \"College\" button under Overall Position Indicator",
  "keyword": "Given "
});
formatter.match({
  "location": "OverallPositionIndicatorStepDefs.user_enters_the_valid_credentials_and_clicks_button_under_Overall_Position_Indicator(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "gets the values from the Rank-field both for the User and the Topper",
  "keyword": "When "
});
formatter.match({
  "location": "OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"org.pom.pages.StduentDashBoard.getcStudentRank()\" because \"this.db\" is null\r\n\tat org.stepdefinition.OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper(OPISteps.java:63)\r\n\tat ✽.gets the values from the Rank-field both for the User and the Topper(file:OPI.feature:9)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "verify it matches the Source Test Data",
  "keyword": "Then "
});
formatter.match({
  "location": "OPISteps.verify_it_matches_the_Source_Test_Data()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "any data mismatch will be updated in the Mismatch Tracker",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.any_data_mismatch_will_be_updated_in_the_Mismatch_Tracker()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OPIdistrict"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enters the valid credentials and clicks \"District\" button under Overall Position Indicator",
  "keyword": "Given "
});
formatter.match({
  "location": "OverallPositionIndicatorStepDefs.user_enters_the_valid_credentials_and_clicks_button_under_Overall_Position_Indicator(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "gets the values from the Rank-field both for the User and the Topper",
  "keyword": "When "
});
formatter.match({
  "location": "OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"org.pom.pages.StduentDashBoard.getcStudentRank()\" because \"this.db\" is null\r\n\tat org.stepdefinition.OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper(OPISteps.java:63)\r\n\tat ✽.gets the values from the Rank-field both for the User and the Topper(file:OPI.feature:18)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "verify it matches the Source Test Data",
  "keyword": "Then "
});
formatter.match({
  "location": "OPISteps.verify_it_matches_the_Source_Test_Data()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "any data mismatch will be updated in the Mismatch Tracker",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.any_data_mismatch_will_be_updated_in_the_Mismatch_Tracker()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OPIstate"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enters the valid credentials and clicks \"State\" button under Overall Position Indicator",
  "keyword": "Given "
});
formatter.match({
  "location": "OverallPositionIndicatorStepDefs.user_enters_the_valid_credentials_and_clicks_button_under_Overall_Position_Indicator(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "gets the values from the Rank-field both for the User and the Topper",
  "keyword": "When "
});
formatter.match({
  "location": "OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"org.pom.pages.StduentDashBoard.getcStudentRank()\" because \"this.db\" is null\r\n\tat org.stepdefinition.OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper(OPISteps.java:63)\r\n\tat ✽.gets the values from the Rank-field both for the User and the Topper(file:OPI.feature:26)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "verify it matches the Source Test Data",
  "keyword": "Then "
});
formatter.match({
  "location": "OPISteps.verify_it_matches_the_Source_Test_Data()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "any data mismatch will be updated in the Mismatch Tracker",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.any_data_mismatch_will_be_updated_in_the_Mismatch_Tracker()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
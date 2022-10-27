$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/OPI.feature");
formatter.feature({
  "name": "To verify the Ranking fields in overall postion indicator with source data",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User fill the username and paasword with valid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user should be in student dashboard page",
  "keyword": "Given "
});
formatter.match({
  "location": "OPISteps.the_user_should_be_in_student_dashboard_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters the valid credentials to login student module",
  "keyword": "When "
});
formatter.match({
  "location": "OPISteps.enters_the_valid_credentials_to_login_student_module()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user clicks the Login button",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.the_user_clicks_the_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters the OTP",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.enters_the_OTP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks the Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.clicks_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "student profile page should be opened",
  "keyword": "Then "
});
formatter.match({
  "location": "OPISteps.student_profile_page_should_be_opened()"
});
formatter.result({
  "status": "passed"
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
formatter.step({
  "name": "the user clicks College button under Overall Position Indicator",
  "keyword": "When "
});
formatter.match({
  "location": "OPISteps.the_user_clicks_College_button_under_Overall_Position_Indicator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "gets the values from the Rank-field both for the User and the Topper",
  "keyword": "And "
});
formatter.match({
  "location": "OPISteps.gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify it matches the Source Test Data",
  "keyword": "Then "
});
formatter.match({
  "location": "OPISteps.verify_it_matches_the_Source_Test_Data()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: Verify rank in source data (excel) with application:  expected:\u003c1[]\u003e but was:\u003c1[/2]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.stepdefinition.OPISteps.verify_it_matches_the_Source_Test_Data(OPISteps.java:194)\r\n\tat ✽.verify it matches the Source Test Data(file:src/test/resources/Features/OPI.feature:22)\r\n",
  "status": "failed"
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
});
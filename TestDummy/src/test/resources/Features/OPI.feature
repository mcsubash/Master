

Feature: To verify the Ranking fields in overall postion indicator with source data



Scenario: User fill the username and paasword with valid credentials
Given the user should be in student dashboard page

When enters the valid credentials to login student module
    And The user clicks the Login button
    And enters the OTP
    And clicks the Submit button
    Then student profile page should be opened 

  

  @OPIcollege
   Scenario: Getting the College Ranking field from the Overall Position Indicator and compare with the source Test Data
   When the user clicks College button under Overall Position Indicator
   And gets the values from the Rank-field both for the User and the Topper
   Then verify it matches the Source Test Data
   And any data mismatch will be updated in the Mismatch Tracker
   
   
   
   #@OPIdistrict
   #Scenario: Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data
#
   
   #
   #When the user clicks College button under Overall Position Indicator
   #And gets the values from the Rank-field both for the User and the Topper
   #Then verify it matches the Source Test Data
   #And any data mismatch will be updated in the Mismatch Tracker
       #
  #@OPIstate
   #Scenario: Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data
#
   #Given the user should be logged-in to the application with valid credentials
   #
   #When the user clicks College button under Overall Position Indicator
   #And gets the values from the Rank-field both for the User and the Topper
   #Then verify it matches the Source Test Data
   #And any data mismatch will be updated in the Mismatch Tracker 
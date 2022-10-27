

Feature: To verify the Ranking fields in overall postion indicator with source data
   
   @OPIcollege
   Scenario: Getting the College Ranking field from the Overall Position Indicator and compare with the source Test Data
   
   Given user enters the valid credentials and clicks "College" button under Overall Position Indicator
   When gets the values from the Rank-field both for the User and the Topper
   Then verify it matches the Source Test Data
   And any data mismatch will be updated in the Mismatch Tracker
   
   
   @OPIdistrict
   Scenario: Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data

   Given user enters the valid credentials and clicks "District" button under Overall Position Indicator
   When gets the values from the Rank-field both for the User and the Topper
   Then verify it matches the Source Test Data
   And any data mismatch will be updated in the Mismatch Tracker
       
  @OPIstate
   Scenario: Getting the District Ranking field from the Overall Position Indicator and compare with the source Test Data

   Given user enters the valid credentials and clicks "State" button under Overall Position Indicator
   When gets the values from the Rank-field both for the User and the Topper
   Then verify it matches the Source Test Data
   And any data mismatch will be updated in the Mismatch Tracker
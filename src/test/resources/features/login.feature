Feature: login to test functionality

  Scenario Outline: Check login success with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page
    And close browser
  Examples: 
      |username|password|
      |"pepito" |12345|
      |"juanita" |12345|

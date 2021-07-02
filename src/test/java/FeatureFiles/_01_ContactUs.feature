Feature: ContactUs Funtionality

  Background:
    Given Navigate to Webpage
    When Enter username and password and click login button
    Then User should login successfully
    And Open the ContactUs

  Scenario: Select Customer service and add email with message
    When Selecting Customer service from Subject Head
    And Adding email
    Then Add mesage to box
    Then Send Message
    Then Message should be send successfully

  Scenario: Select Customer service and add email without message
    When Selecting Customer service from Subject Head
    And Adding email
    Then Send Message
    Then Message should be send Cannot be blank

  Scenario: Select Customer service and add email and add file with message
    When Selecting Customer service from Subject Head
    And Adding email
    Then Add mesage to box
    And Add file
    Then Send Message
    Then Message should be send successfully







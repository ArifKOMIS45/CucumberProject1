Feature: Specials Functionality
  Background:
    Given Navigate to Webpage
    When Enter username and password and click login button
    Then User should login successfully
    And Open the Specials

  Scenario:Specials page add a product
    Then Add a product to chart
    Then Chart should contain the selected product

  Scenario:Specials page add a product then delete
    Then Add a product to chart
    When Product added then delete it
    Then Chart should not contain the selected product

  Scenario:Specials page add a product then complete order
    Then Add a product to chart
    When The product order steps confirmed
    Then Order confirmation should be seen
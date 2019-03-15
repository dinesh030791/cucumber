#Author: Dinesh kumar
Feature: To test add customer

  Scenario: Add customer
    Given The user to be in add customer page
    When The user needs to fill the customer details
    And The user needs to click the submit button
    Then The user able to see the success message
    And The user able to see the customer ID

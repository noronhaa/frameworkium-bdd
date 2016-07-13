@fail
Feature: Have a test that fails to demonstrate how failed tests show up in reports

  Scenario: Demonstrating a test that fails by logging in with incorrect details
    Given I have successfully logged in
    Then the home page title will be 'this is not the home page title'
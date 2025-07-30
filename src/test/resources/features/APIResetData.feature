Feature: Reset ENSEK test data

  Scenario: Reset test data successfully
    Given I am authenticated for reset
    When I reset the ENSEK test data
    Then the reset should be successful

Feature: Getting energy details from the ENSEK API

  Background:
    Given I am authenticated for energy retrieval
    And the ENSEK test data is reset for energy retrieval

  Scenario: Get energy details and verify all energy types are present
    When I get energy details
    Then the response should contain "electric"
    And the response should contain "gas"
    And the response should contain "nuclear"
    And the response should contain "oil"
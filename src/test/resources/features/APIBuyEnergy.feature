Feature: Buying energy units from the ENSEK API

  Background:
    Given I am authenticated
    And the ENSEK test data is reset

  Scenario Outline: Buy energy and verify unit reduction
    When I buy <quantity> units with ID <id>
    Then the remaining quantity for ID <id> should be <expectedRemaining>

    Examples:
      | id | quantity | expectedRemaining |
      | 1  | 15       | 2985              |
      | 2  | 15       | 0                 |
      | 3  | 15       | 4307              |
      | 4  | 15       | 5                 |

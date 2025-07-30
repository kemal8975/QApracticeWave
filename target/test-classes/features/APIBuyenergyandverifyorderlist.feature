Feature: Buy energy and verify order ID exists in orders list

  Background:
    Given I am authenticated as user
    And the ENSEK test data is reseted

  Scenario Outline: Buy energy and verify order exists in orders list
    When customer buy <quantity> units with ID <id>
    Then the extracte order ID should exist in the orders list

    Examples:
      | id | quantity |
      | 1  | 15       |

      | 3  | 15       |
      | 4  | 15       |

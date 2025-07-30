Feature: Confirm orders created before current date

  Scenario: Count orders created before current date
    Given I am authenticated for orders check
    When I get all orders from the system
    Then the number of orders created before current date should be more than 1

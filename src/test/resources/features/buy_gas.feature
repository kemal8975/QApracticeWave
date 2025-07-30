Feature: Buy Gas energy units

  Background:
    Given I am on the energy buy page
    And I press the reset button

  Scenario: Buy 5 units of Gas
    When I buy 5 units of Gas
    Then I should see the confirmation message:
      """
      Thank you for your purchase of 5 units of Gas
      We have popped it in the post and it will be with you shortly.
      There are now 2995 units of Gas left in our stores.
      """

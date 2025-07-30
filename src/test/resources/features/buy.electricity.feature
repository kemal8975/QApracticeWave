Feature: Buy Electricity Energy

  Background:
    Given I am on the Energy Purchase Page
    And I press the Reset button on the Energy Purchase Page

  Scenario: Purchase 10 units of Electricity
    When I purchase 10 units of Electricity energy
    Then I should see the electricity purchase confirmation message:
  """
  Thank you for your purchase of 10 units of Electricity We have popped it in the post and it will be with you shortly.
  There are now 4312 units of Electricity left in our stores.
  """


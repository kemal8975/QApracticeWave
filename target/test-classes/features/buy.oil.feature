Feature: Oil Purchase Functionality

  Scenario: Successfully purchase oil energy units
    Given User is on the energy purchase page
    And User clicks the reset button
    When User purchases 5 units of Oil
    Then User should see the confirmation for oil purchase:
      """
      Thank you for your purchase of 5 units of Oil We have popped it in the post and it will be with you shortly.
      There are now 15 units of Oil left in our stores.
      """

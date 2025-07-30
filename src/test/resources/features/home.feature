Feature: Homepage Functionality

  Scenario: Verify homepage title, content, and navigation
    Given I am on the homepage
    Then the page title should be "ENSEK Energy Corp. - Candidate Test"
    And the main heading should be "ENSEK Energy Corp."
    When I click the "Buy energy »" link, it should be clickable
    And I click the "Sell energy »" link, it should be clickable
    And I click the "Learn more »" link, it should be clickable
    And I click the "Find out more »" link, it should be clickable


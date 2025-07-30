Feature: About Page

  Scenario: Verify About page and external link
    Given I am on the homepage
    When I click the "About" link in the navbar
    Then the page title should "About ENSEK Energy Corp. - Candidate Test"
    When I click the "Find out more about us »" button
    Then the page should not be a 404 error

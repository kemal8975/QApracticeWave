Feature: Contact Page

  Scenario: Verify Contact page title and absence of error image
    Given I open the homepage for contact tests
    When I navigate to the Contact page via navbar
    Then the Contact page title should be "Contact - Candidate Test"
    And the error image with src "/Content/Images/Error-message.jpg" should NOT be present

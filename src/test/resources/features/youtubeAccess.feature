Feature: Login and Fill Form on YouTube

  @youtube
  Scenario: The user logs into YouTube and fills in the login form
    Given the user is on the YouTube homepage
    When the user clicks on "Access"
    And the user fills in the login form with valid credentials
    Then the user should be logged in successfully

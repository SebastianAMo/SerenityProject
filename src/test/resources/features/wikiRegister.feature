Feature: Account Creation on Wikipedia

  Scenario: The user attempts to create an account without filling in the CAPTCHA
    Given the user is on the Wikipedia homepage
    When the user selects the "Create an account" option
    And the user completes the form but leaves the CAPTCHA field empty
    Then the user submits the form by clicking "Create your account"

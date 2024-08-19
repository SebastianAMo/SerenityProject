Feature: Account Creation on Wikipedia

  @wiki
  Scenario: The user attempts to create an account without filling in the CAPTCHA
    Given the user "Sebas" is on the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    When the user selects the Create an account option
    And the user completes the form but leaves the CAPTCHA field empty
    And the user submits the form by clicking Create your account
    Then the user should see a message indicating that the CAPTCHA field is required

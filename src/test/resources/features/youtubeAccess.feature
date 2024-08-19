Feature: Login and Fill Form on YouTube

  @youtube
  Scenario: The user logs into YouTube and fills in the login form
    Given the user "Sebas" is on the page "https://www.youtube.com/?themeRefresh=1"
    When the user clicks on "Access"
    Then the user fills in the login form with valid credentials


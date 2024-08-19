Feature: Title Validation on Wikipedia

  @wiki
  Scenario: The user validates the title "Welcome to Wikipedia" on the homepage
    Given the user "Sebas" is on the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    Then the user should see the title "Bienvenidos a Wikipedia,"

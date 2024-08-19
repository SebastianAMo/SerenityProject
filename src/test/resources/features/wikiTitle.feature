Feature: Title Validation on Wikipedia

  @wiki
  Scenario: The user validates the title "Welcome to Wikipedia" on the homepage
    Given the user is on the Wikipedia homepage at "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    Then the user should see the title "Bienvenidos a Wikipedia,"

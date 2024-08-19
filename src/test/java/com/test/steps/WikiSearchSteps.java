package com.test.steps;

import com.test.interactions.OpenPage;
import com.test.tasks.wiki.SearchForTerm;
import com.test.tasks.wiki.ScrollToSection;
import com.test.questions.wiki.TitleDisplayed;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.annotations.Managed;
import static org.junit.Assert.assertTrue;

public class WikiSearchSteps {

    Actor user = Actor.named("User");

    @Managed
    WebDriver hisBrowser;

    @Given("the user is on the Wikipedia")
    public void theUserIsOnTheWikipediaHomepage() {
        user.can(BrowseTheWeb.with(hisBrowser));
        user.attemptsTo(OpenPage.at("https://es.wikipedia.org/wiki/Wikipedia:Portada"));
    }

    @When("the user performs a search for the term {string}")
    public void theUserSearchesForTheTerm(String searchTerm) {
        user.attemptsTo(SearchForTerm.called(searchTerm));
    }

    @And("the user scrolls down to locate the section {string}")
    public void theUserScrollsToFindTheSection(String sectionTitle) {
        user.attemptsTo(ScrollToSection.ceemAnalysis());
    }

    @Then("the title displayed should be {string}")
    public void theUserShouldSeeTheTitle(String expectedTitle) {
        assertTrue(user.asksFor(TitleDisplayed.is(expectedTitle)));
    }
}

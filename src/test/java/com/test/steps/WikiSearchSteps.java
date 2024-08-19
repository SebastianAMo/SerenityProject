package com.test.steps;

import com.test.tasks.wiki.SearchForTerm;
import com.test.tasks.wiki.ScrollToSection;
import com.test.questions.wiki.TitleDisplayed;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WikiSearchSteps {

    @When("the user performs a search for the term {string}")
    public void theUserSearchesForTheTerm(String searchTerm) {
        theActorInTheSpotlight().attemptsTo(SearchForTerm.called(searchTerm));
    }

    @And("the user scrolls down to locate the section {string}")
    public void theUserScrollsToFindTheSection(String sectionTitle) {
        theActorInTheSpotlight().attemptsTo(ScrollToSection.ceemAnalysis());
    }

    @Then("the title displayed should be {string}")
    public void theUserShouldSeeTheTitle(String expectedTitle) {
        assertTrue(theActorInTheSpotlight().asksFor(TitleDisplayed.is(expectedTitle)));
    }
}

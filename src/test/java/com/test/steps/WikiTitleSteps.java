package com.test.steps;

import com.test.questions.wiki.WikiTitle;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class WikiTitleSteps {

    @Then("the user should see the title {string}")
    public void theUserShouldSeeTheTitle(String expectedTitle) {
        assertTrue(theActorInTheSpotlight().asksFor(WikiTitle.is(expectedTitle)));
    }
}

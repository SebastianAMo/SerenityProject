package com.test.steps;

import com.test.questions.wiki.WikiTitle;
import com.test.tasks.wiki.OpenWikipedia;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.junit.Assert.assertTrue;


public class WikiTitleSteps {

    @Managed(driver = "chrome")
    Actor user;

    @Given("the user is on the Wikipedia homepage at {string}")
    public void theUserIsOnTheWikipediaHomepage(String url) {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.attemptsTo(OpenWikipedia.homepage());

    }

    @Then("the user should see the title {string}")
    public void theUserShouldSeeTheTitle(String expectedTitle) {
        assertTrue(user.asksFor(WikiTitle.is(expectedTitle)));
    }
}

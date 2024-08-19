package com.test.steps;

import com.test.interactions.OpenPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user {string} is on the page {string}")
    public void theUserIsOnThePage(String actorName, String url) {
        theActorCalled(actorName).attemptsTo(OpenPage.at(url));
    }

    @After
    public void tearDown() {
        // TODO: Add code to close the browser
    }
}
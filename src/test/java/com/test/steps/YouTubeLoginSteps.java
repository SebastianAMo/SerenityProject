package com.test.steps;

import com.test.tasks.youtube.ClickOnSignIn;
import com.test.tasks.youtube.FillLoginForm;
import com.test.questions.wiki.WelcomMessage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class YouTubeLoginSteps {


    @When("the user clicks on {string}")
    public void userClicksOnSignIn(String buttonText){
        theActorInTheSpotlight().attemptsTo(ClickOnSignIn.button());

    }

    @And("the user fills in the login form with valid credentials")
    public void userFillsInLoginForm(){
        theActorInTheSpotlight().attemptsTo(FillLoginForm.withCredentials("sebastian.agudelo2@utp.edu.co", "your_password"));
    }

    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        theActorInTheSpotlight().should(seeThat(WelcomMessage.displayed()));
    }
}

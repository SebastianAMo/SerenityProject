package com.test.steps;

import com.test.tasks.youtube.ClickOnSignIn;
import com.test.tasks.youtube.FillLoginForm;
import com.test.questions.wiki.WelcomMessage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class YouTubeLoginSteps {

    private Actor user = OnStage.theActorCalled("User");

    @When("the user clicks on {string}")
    public void userClicksOnSignIn(String buttonText){
        user.attemptsTo(ClickOnSignIn.button());

    }

    @And("the user fills in the login form with valid credentials")
    public void userFillsInLoginForm(){
        user.attemptsTo(FillLoginForm.withCredentials("sebastian.agudelo2@utp.edu.co", "your_password"));
    }

    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        user.should(seeThat(WelcomMessage.displayed()));
    }
}

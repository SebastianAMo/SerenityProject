package com.test.steps;

import com.test.interactions.OpenPage;
import com.test.tasks.wiki.OpenAccountCreationPage;
import com.test.tasks.wiki.FillAccountCreationFormWithoutCaptcha;
import com.test.tasks.wiki.SubmitAccountCreationForm;
import com.test.questions.wiki.CaptchaIsRequired;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.junit.Assert.assertTrue;
public class WikiAccountCreationSteps {



    @When("the user selects the Create an account option")
    public void theUserSelectsCreateAccountOption() {
        theActorInTheSpotlight().attemptsTo(OpenAccountCreationPage.onWikipedia());
    }

    @And("the user completes the form but leaves the CAPTCHA field empty")
    public void theUserCompletesFormWithoutCaptcha() {
        theActorInTheSpotlight().attemptsTo(FillAccountCreationFormWithoutCaptcha.withDetails("TestUser", "TestPass123", "TestPass123", "test@example.com"));
    }

    @And("the user submits the form by clicking Create your account")
    public void theUserSubmitsTheForm() {
        theActorInTheSpotlight().attemptsTo(SubmitAccountCreationForm.now());
    }

    @Then("the user should see a message indicating that the CAPTCHA field is required")
    public void theUserShouldSeeCaptchaIsRequiredMessage() {
        assertTrue(theActorInTheSpotlight().asksFor(CaptchaIsRequired.isPresent()));
    }


}

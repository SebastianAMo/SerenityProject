package com.test.steps;

import com.test.tasks.wiki.OpenAccountCreationPage;
import com.test.tasks.wiki.FillAccountCreationFormWithoutCaptcha;
import com.test.tasks.wiki.OpenWikipedia;
import com.test.tasks.wiki.SubmitAccountCreationForm;
import com.test.questions.wiki.CaptchaIsRequired;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
public class WikiAccountCreationSteps {

    Actor user = Actor.named("User");

    @Managed
    WebDriver hisBrowser;


    @Given("the user is on the Wikipedia homepage")
    public void theUserIsOnTheWikipediaHomepage() {
        user.can(BrowseTheWeb.with(hisBrowser));
        user.attemptsTo(OpenWikipedia.homepage());
    }


    @When("the user selects the {string} option")
    public void theUserSelectsCreateAccountOption(String option) {
        user.attemptsTo(OpenAccountCreationPage.onWikipedia());
    }

    @And("the user completes the form but leaves the CAPTCHA field empty")
    public void theUserCompletesFormWithoutCaptcha() {
        user.attemptsTo(FillAccountCreationFormWithoutCaptcha.withDetails("TestUser", "TestPass123", "TestPass123", "test@example.com"));
    }

    @And("the user submits the form by clicking {string}")
    public void theUserSubmitsTheForm(String button) {
        user.attemptsTo(SubmitAccountCreationForm.now());
    }

    @Then("the user should see a message indicating that the CAPTCHA field is required")
    public void theUserShouldSeeCaptchaIsRequiredMessage() {
        assertTrue(user.asksFor(CaptchaIsRequired.isPresent()));
    }


}

package com.test.steps;

import com.test.tasks.OpenYouTube;
import com.test.tasks.SearchSong;
import com.test.questions.VideoTitle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class youtubeSearchSteps {


    @Managed(driver = "chrome")
    Actor user;

    @Given("the user is on the YouTube homepage")
    public void the_user_is_on_the_YouTube_homepage() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.attemptsTo(OpenYouTube.homePage());
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String songName) {
        user.attemptsTo(SearchSong.named(songName));
    }

    @Then("the user selects the first result")
    public void the_user_selects_the_first_result() {
        user.attemptsTo(SearchSong.selectFirstResult());
    }

    @Then("the user should see the video title as {string}")
    public void the_user_should_see_the_video_title_as(String expectedTitle) {
        String actualTitle = VideoTitle.displayed().answeredBy(user);
        System.out.println("Actual Title: " + actualTitle);
    }
}

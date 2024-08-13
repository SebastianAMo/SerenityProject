package com.test.steps;

import com.test.tasks.youtube.OpenYouTube;
import com.test.tasks.youtube.SearchSong;
import com.test.tasks.youtube.SelectFirstResult;
import com.test.questions.VideoTitle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class YoutubeSearchSteps {


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
        user.attemptsTo(SelectFirstResult.video());
    }

    @Then("the user should see the video title as {string}")
    public void the_user_should_see_the_video_title_as(String expectedTitle) {
        user.should(seeThat(VideoTitle.displayed(), is(expectedTitle)));
    }
}

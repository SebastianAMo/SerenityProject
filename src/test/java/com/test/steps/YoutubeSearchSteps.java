package com.test.steps;

import com.test.tasks.youtube.SearchSong;
import com.test.tasks.youtube.SelectFirstResult;
import com.test.questions.youtube.VideoTitle;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class YoutubeSearchSteps {
    @When("the user searches for {string}")
    public void the_user_searches_for(String songName) {
        theActorInTheSpotlight().attemptsTo(SearchSong.named(songName));
    }

    @And("the user selects the first result")
    public void the_user_selects_the_first_result() {
        theActorInTheSpotlight().attemptsTo(SelectFirstResult.video());
    }

    @Then("the user should see the video title as {string}")
    public void the_user_should_see_the_video_title_as(String expectedTitle) {
        theActorInTheSpotlight().should(seeThat(VideoTitle.displayed(), is(expectedTitle)));
    }
}

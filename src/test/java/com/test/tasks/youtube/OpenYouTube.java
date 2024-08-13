package com.test.tasks.youtube;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

public class OpenYouTube implements Task {

    private static final String YOUTUBE_URL = "https://www.youtube.com/?themeRefresh=1";

    public static OpenYouTube homePage() {
        return new OpenYouTube();
    }

    @Override
    @Step("{0} opens the YouTube homepage")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(YOUTUBE_URL));
    }
}

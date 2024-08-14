package com.test.questions.youtube;

import com.test.ui.YouTubePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VideoTitle implements Question<String> {

    public static VideoTitle displayed() {
        return new VideoTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(YouTubePage.VIDEO_TITLE, isVisible()).forNoMoreThan(20).seconds();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return BrowseTheWeb.as(actor).find(YouTubePage.VIDEO_TITLE).getText();
    }
}

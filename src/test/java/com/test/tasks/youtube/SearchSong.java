package com.test.tasks.youtube;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.test.ui.YouTubePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchSong implements Task {

    private final String songName;

    public SearchSong(String songName) {
        this.songName = songName;
    }

    public static SearchSong named(String songName) {
        return instrumented(SearchSong.class, songName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(YouTubePage.SEARCH_BAR, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(songName).into(YouTubePage.SEARCH_BAR),
                Click.on(YouTubePage.SEARCH_BUTTON)
        );
    }
}
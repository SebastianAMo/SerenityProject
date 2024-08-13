package com.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchSong implements Task {

    private final String songName;

    public SearchSong(String songName) {
        this.songName = songName;
    }

    public static SearchSong named(String songName) {
        return instrumented(SearchSong.class, songName);
    }

    public static Task selectFirstResult() {
        return Task.where("{0} selects the first search result",
                WaitUntil.the(By.cssSelector("ytd-video-renderer"), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(By.cssSelector("ytd-video-renderer"))
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(songName).into(By.name("search_query")),
                Click.on(By.id("search-icon-legacy")),
                Scroll.to(By.cssSelector("ytd-video-renderer")),
                WaitUntil.the(By.cssSelector("ytd-video-renderer"), isVisible()).forNoMoreThan(10).seconds()
        );
    }
}

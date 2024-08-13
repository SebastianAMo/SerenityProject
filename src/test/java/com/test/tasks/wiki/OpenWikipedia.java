package com.test.tasks.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import com.test.ui.WikiPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWikipedia implements Task {

    private static final String WIKI_URL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(WIKI_URL));
    }

    public static OpenWikipedia homepage() {
        return instrumented(OpenWikipedia.class);
    }
}

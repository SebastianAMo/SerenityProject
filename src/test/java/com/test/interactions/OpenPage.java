package com.test.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Interaction {

    private final String url;

    public OpenPage(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static Performable at(String url) {
        return instrumented(OpenPage.class, url);
    }
}

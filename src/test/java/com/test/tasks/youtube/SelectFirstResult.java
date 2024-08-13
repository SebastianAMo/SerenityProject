package com.test.tasks.youtube;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.test.ui.YouTubePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFirstResult implements Task {

    public static SelectFirstResult video() {
        return instrumented(SelectFirstResult.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(YouTubePage.FIRST_VIDEO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(YouTubePage.FIRST_VIDEO)
        );
    }
}

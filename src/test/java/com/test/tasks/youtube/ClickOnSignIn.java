package com.test.tasks.youtube;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;
import com.test.ui.YouTubePage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnSignIn implements Task {

    public static ClickOnSignIn button() {
        return instrumented(ClickOnSignIn.class);
    }

    @Override
    @Step("{0} clicks on the Sign In")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(YouTubePage.SIGN_IN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(YouTubePage.SIGN_IN)
        );
    }
}

package com.test.tasks.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.test.ui.WikiPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubmitAccountCreationForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WikiPage.CREATE_ACCOUNT_BUTTON_SUBMIT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(WikiPage.CREATE_ACCOUNT_BUTTON_SUBMIT)
        );
    }

    public static SubmitAccountCreationForm now() {
        return instrumented(SubmitAccountCreationForm.class);
    }
}

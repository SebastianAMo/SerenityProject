package com.test.tasks.youtube;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import com.test.ui.YouTubePage;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillLoginForm implements Task {

    private final String username;
    private final String password;

    public FillLoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static FillLoginForm withCredentials(String username, String password) {
        return instrumented(FillLoginForm.class, username, password);
    }

    @Override
    @Step("{0} fills in the login form with valid credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(YouTubePage.EMAIL_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(YouTubePage.EMAIL_FIELD),
                Click.on(YouTubePage.NEXT_BUTTON),

                WaitUntil.the(YouTubePage.PASSWORD_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(YouTubePage.PASSWORD_FIELD),
                Click.on(YouTubePage.SIGN_IN_BUTTON)
        );
    }
}

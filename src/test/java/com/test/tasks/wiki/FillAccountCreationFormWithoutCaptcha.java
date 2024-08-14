package com.test.tasks.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.test.ui.WikiPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillAccountCreationFormWithoutCaptcha implements Task {

    private final String username;
    private final String password;
    private final String confirmPassword;
    private final String email;

    public FillAccountCreationFormWithoutCaptcha(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WikiPage.USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(WikiPage.USERNAME_FIELD),
                Enter.theValue(password).into(WikiPage.PASSWORD_FIELD),
                Enter.theValue(confirmPassword).into(WikiPage.CONFIRM_PASSWORD_FIELD),
                Enter.theValue(email).into(WikiPage.EMAIL_FIELD)
                // Aquí no se llena el campo CAPTCHA
        );
    }

    public static FillAccountCreationFormWithoutCaptcha withDetails(String username, String password, String confirmPassword, String email) {
        return instrumented(FillAccountCreationFormWithoutCaptcha.class, username, password, confirmPassword, email);
    }
}

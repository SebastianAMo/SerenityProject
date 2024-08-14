package com.test.questions.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.test.ui.WikiPage;

public class CaptchaIsRequired implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verifica si el atributo "required" está presente en el campo CAPTCHA
        return WikiPage.CAPTCHA_INPUT.resolveFor(actor).getAttribute("required") != null;
    }

    public static CaptchaIsRequired isPresent() {
        return new CaptchaIsRequired();
    }
}

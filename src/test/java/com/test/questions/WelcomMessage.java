package com.test.questions;

import com.test.ui.YouTubePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WelcomMessage implements Question<Boolean> {

    public static WelcomMessage displayed() {
        return new WelcomMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(YouTubePage.WELCOME_MESSAGE, isVisible()).forNoMoreThan(10).seconds();
        return BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("//*[@id=\"headingText\"]/span")).isDisplayed();
    }
}
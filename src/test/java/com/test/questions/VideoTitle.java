package com.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VideoTitle implements Question<String> {

    public static VideoTitle displayed() {
        return new VideoTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(By.xpath("//*[@id=\"title\"]/h1/yt-formatted-string"), isVisible()).forNoMoreThan(10).seconds();
        return BrowseTheWeb.as(actor).find(By.xpath("//*[@id=\"title\"]/h1/yt-formatted-string")).getText();
    }
}

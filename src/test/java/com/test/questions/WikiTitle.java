package com.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.test.ui.WikiPage;

public class WikiTitle implements Question<Boolean> {

    private final String expectedTitle;

    public WikiTitle(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualTitle = WikiPage.TITLE.resolveFor(actor).getText();
        return actualTitle.equals(expectedTitle);
    }

    public static WikiTitle is(String title) {
        return new WikiTitle(title);
    }
}

package com.test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.test.ui.WikiPage;

public class TitleDisplayed implements Question<Boolean> {

    private final String expectedTitle;

    public TitleDisplayed(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualTitle = WikiPage.CEEM_ANALYSIS_SECTION.resolveFor(actor).getText();
        return actualTitle.equals(expectedTitle);
    }

    public static TitleDisplayed is(String title) {
        return new TitleDisplayed(title);
    }
}

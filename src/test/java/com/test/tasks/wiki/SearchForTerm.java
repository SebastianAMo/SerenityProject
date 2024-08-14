package com.test.tasks.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import com.test.ui.WikiPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchForTerm implements Task {

    private final String searchTerm;

    public SearchForTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public static SearchForTerm called(String searchTerm) {
        return instrumented(SearchForTerm.class, searchTerm);
    }

    @Override
    @Step("{0} searches for the term '#searchTerm'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WikiPage.SEARCH_BOX, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(searchTerm).into(WikiPage.SEARCH_BOX),

                WaitUntil.the(WikiPage.SEARCH_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(WikiPage.SEARCH_BUTTON)
        );
    }
}

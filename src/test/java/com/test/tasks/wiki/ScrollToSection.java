package com.test.tasks.wiki;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import com.test.ui.WikiPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollToSection implements Task {

    @Override
    @Step("{0} scrolls to the CEEM Analysis section on the page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WikiPage.CEEM_ANALYSIS_SECTION, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(WikiPage.CEEM_ANALYSIS_SECTION)
        );
    }

    public static ScrollToSection ceemAnalysis() {
        return instrumented(ScrollToSection.class);
    }
}

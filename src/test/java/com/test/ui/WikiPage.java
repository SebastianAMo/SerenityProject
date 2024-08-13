package com.test.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WikiPage {
    public static final Target TITLE = Target.the("Title on the homepage")
            .located(By.xpath("//*[@id=\"Bienvenidos_a_Wikipedia,\"]"));
}

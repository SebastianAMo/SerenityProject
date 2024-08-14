package com.test.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WikiPage {
    public static final Target TITLE = Target.the("Title on the homepage")
            .located(By.xpath("//*[@id=\"Bienvenidos_a_Wikipedia,\"]"));


    public static final Target SEARCH_BOX = Target.the("search box")
            .located(By.name("search"));
    public static final Target SEARCH_BUTTON = Target.the("search button")
            .located(By.xpath("//*[@id=\"searchform\"]/div/button"));
    public static final Target CEEM_ANALYSIS_SECTION = Target.the("CEEM Analysis section")
            .located(By.xpath("/html/body/div[2]/div/div[3]/main/div[3]/div[3]/div[1]/div[11]/h3"));

    // Register page

    public static final Target CREATE_ACCOUNT_BUTTON = Target.the("Create Account button")
            .located(By.xpath("/html/body/div[1]/header/div[2]/nav/div[1]/div[4]/div/ul/li[1]/a"));

    public static final Target USERNAME_FIELD = Target.the("Username field")
            .located(By.id("wpName2"));

    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.id("wpPassword2"));

    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("Confirm password field")
            .located(By.id("wpRetype"));

    public static final Target EMAIL_FIELD = Target.the("Email field")
            .located(By.id("wpEmail"));

    public static final Target CREATE_ACCOUNT_BUTTON_SUBMIT = Target.the("Create your account button")
            .located(By.id("wpCreateaccount"));

}

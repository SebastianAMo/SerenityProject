package com.test.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YouTubePage {


    // Home Page
    public static final Target SIGN_IN = Target.the("sign in button")
            .located(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/yt-button-shape/a"));

    public static final Target SEARCH_BAR = Target.the("search bar").located(By.name("search_query"));
    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.id("search-icon-legacy"));
    public static final Target FIRST_VIDEO = Target.the("first video result").located(By.xpath("(//a[@id='video-title'])[1]"));
    public static final Target VIDEO_TITLE = Target.the("video title")
            .located(By.xpath("//*[@id=\"title\"]/h1/yt-formatted-string"));

    // Sign In Page
    public static final Target EMAIL_FIELD = Target.the("email field")
            .located(By.id("identifierId"));
    public static final Target NEXT_BUTTON = Target.the("next button")
            .located(By.id("identifierNext"));
    public static final Target PASSWORD_FIELD = Target.the("password field")
            .located(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
    public static final Target SIGN_IN_BUTTON = Target.the("sign in button")
            .located(By.id("passwordNext"));

    public static final Target WELCOME_MESSAGE = Target.the("welcome message")
            .located(By.xpath("//*[@id=\"headingText\"]/span"));
}

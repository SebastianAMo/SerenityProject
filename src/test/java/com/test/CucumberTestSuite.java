package com.test;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.test.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class CucumberTestSuite {
}

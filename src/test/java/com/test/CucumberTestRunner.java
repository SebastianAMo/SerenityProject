package com.test;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.test.steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@wiki or @youtube"
)
public class CucumberTestRunner {
}

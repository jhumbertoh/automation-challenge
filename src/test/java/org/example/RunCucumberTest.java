package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/json-reports/Cucumber.json",
        "junit:target/cucumber-reports/junit-reports/Cucumber.xml"},
        tags = {"@AmazonStore"},
        glue = {"org.example"},
        features = {"src/test/resources/features"},
        monochrome = true, snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunCucumberTest
{

}
package org.steps.com;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/test/java/Feature"},
plugin = { "pretty", "html:target/cucumber-reports.html" }
)


public class TestRunner {

}
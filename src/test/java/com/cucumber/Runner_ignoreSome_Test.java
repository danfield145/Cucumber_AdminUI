package com.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/json/output.json", "html:target/html/"},
        features = "src/test/resource",
        tags = {"@runme", "~@ignoreMe"}
)


public class Runner_ignoreSome_Test {
}

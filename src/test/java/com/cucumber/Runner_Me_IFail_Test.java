package com.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/json/output.json", "html:target/html/"},
        features = "src/test/resource",
        tags = {"@runme_IFail"}
)


public class Runner_Me_IFail_Test {
}

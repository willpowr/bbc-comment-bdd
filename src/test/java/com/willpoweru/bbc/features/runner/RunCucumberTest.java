package com.willpoweru.bbc.features.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "com.willpoweru.bbc.features.steps",
        features = "classpath:features/comment.feature"
)
public class RunCucumberTest {
}

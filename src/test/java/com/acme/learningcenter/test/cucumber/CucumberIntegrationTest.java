package com.acme.learningcenter.test.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.acme.learningcenter.test.step")
public class CucumberIntegrationTest {
}

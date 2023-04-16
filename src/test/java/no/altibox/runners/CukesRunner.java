package no.altibox.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "no/altibox/step_definitions",
        dryRun = false,
        tags = "@freeMovie"
)
public class CukesRunner {



}

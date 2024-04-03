package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Tags allows to execute specific feature file.

@CucumberOptions(features = "src/test/resources/features",glue = {"stepDefinitions"},
                 monochrome = false,dryRun = false
                ,plugin = {"pretty","json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_test.txt",
        glue = {"stepdefs", "utilities", "hooks"},
        plugin = {"pretty", "html:target/test_report.html"}
)
public class FailedScenarioRunner extends AbstractTestNGCucumberTests {
}

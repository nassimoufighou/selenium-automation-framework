package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"steps", "cucumber"},
        plugin = {"pretty"}
)
public class CucumberLoginRunner extends AbstractTestNGCucumberTests {
}

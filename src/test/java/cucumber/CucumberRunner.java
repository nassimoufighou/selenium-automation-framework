package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps", "cucumber"},
        plugin = {"pretty"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

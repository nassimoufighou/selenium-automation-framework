package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps", "cucumber"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

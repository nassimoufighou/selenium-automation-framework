package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/create_booking.feature",
        glue = {"steps", "cucumber"},
        plugin = {"pretty"}
)
public class CucumberCreateBookingRunner extends AbstractTestNGCucumberTests {
}

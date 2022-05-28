package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/apiTest",
        glue = {"stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/DemoQaTestReport/report.html"},
        monochrome = true
)
@Test
public class APITestRunner extends AbstractTestNGCucumberTests {
}

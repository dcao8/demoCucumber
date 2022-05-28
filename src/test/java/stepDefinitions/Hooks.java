package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.ContextManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;


public class Hooks {

    @Before
    public void BeforeSteps() {
        ContextManager.initializeTestContext();
    }

    @After
    public void AfterSteps() {
        ContextManager.getTestContext().getWebDriversManager().closeDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) ContextManager.getTestContext().getWebDriversManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}

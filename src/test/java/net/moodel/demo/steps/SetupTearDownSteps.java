package net.moodel.demo.steps;

import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.moodel.demo.utils.PropertyUtils;
import org.openqa.selenium.OutputType;

/**
 * Functionality for setup and teardown
 */
public class SetupTearDownSteps extends BaseTest {

    @Before
    public void setup() {
        // This needs to be run once at the very start of any scenario
        instantiateDriverObject();
        configureBrowserBeforeUse();
        PropertyUtils.loadProperties();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(takeScreenshot(), "image/png");
        }
        BaseTest.getDriver().quit();
    }

    @Before("@fail")
    public void setupForSpecificTag() {
        //This code will execute before scenarios with the @fail tag
    }

    @After("@fail")
    public void tearDownForSpecificTag() {
        //This code will execute after scenarios with the @fail tag
    }

    public byte[] takeScreenshot() {
        return BaseTest.getDriver().getScreenshotAs(OutputType.BYTES);
    }

}

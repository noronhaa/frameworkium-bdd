package net.moodel.demo.steps;

import net.moodel.demo.utils.PropertyUtils;
import com.frameworkium.tests.internal.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Functionality for setup and teardown
 */
public class SetupTearDownSteps {

    @Before
    public void setup(){
        PropertyUtils.loadProperties();
        BaseTest.instantiateDriverObject();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(takeScreenshot(), "image/png");
        }
        BaseTest.getDriver().quit();
    }

    @Before("@fail")
    public void setupForSpecificTag(){
        //This code will execute before scenarios with the @fail tag
    }

    @After("@fail")
    public void tearDownForSpecificTag(){
        //This code will execute after scenarios with the @fail tag
    }

    public byte[] takeScreenshot(){
        return  ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}

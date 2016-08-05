package net.moodel.demo.runners;

import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        glue = "net.moodel.demo.steps",
        features = "src/test/resources/features",
        tags = "~@ignore")
@RunWith(Cucumber.class)
public class RunCukesTest{
}

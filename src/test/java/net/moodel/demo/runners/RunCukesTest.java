package net.moodel.demo.runners;

import com.frameworkium.tests.internal.BaseTest;
import cucumber.api.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
                glue = "net.moodel.demo.steps",
                features = "src\\test\\resources\\features",
                tags = "~@ignore")
@RunWith(Cucumber.class)
public class RunCukesTest extends BaseTest{
}

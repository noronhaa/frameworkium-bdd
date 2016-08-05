package net.moodel.demo.utils;

import com.frameworkium.core.ui.tests.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be used to wrap all webdriver functions in methods. All Page
 * Object classes will then use these methods instead of making direct webdriver
 * calls on their initialised elements. This class should not be used in any
 * stepDefinition classes but only called through Page Object classes. All new
 * Webdriver functionality should be added here
 */
public class WebdriverUtils extends BaseTest {

    private static int TIMEOUT = 10;
    private static final WebDriverWait WAIT = new WebDriverWait(getDriver(), TIMEOUT);

    public void click(WebElement webElement) {
        getWebElement(webElement).click();
    }

    public void enterIntoTextField(WebElement element, String text) {
        getWebElement(element).sendKeys(text);
    }

    public String getElementText(WebElement element) {
        return getWebElement(element).getText();
    }

    public String getCurrentPageTitle() {
        return getDriver().getTitle();
    }

    private WebElement getWebElement(WebElement element) {
        return WAIT.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(final WebElement element) {
        try {
            getWebElement(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clearField(WebElement element) {
        getWebElement(element).clear();
    }

}

package net.moodel.demo.pages;

import com.frameworkium.core.ui.pages.BasePage;
import net.moodel.demo.utils.WebdriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyFirstCoursePage extends BasePage<MyFirstCoursePage> {

    WebdriverUtils webdriverUtils = new WebdriverUtils();

    @FindBy(css = ".page-header-headings>h1")
    private WebElement title;

    public String getPageTitleText() {
        return webdriverUtils.getElementText(title);
    }

    public boolean amIonPage() {
        return webdriverUtils.getCurrentPageTitle().contains("Course: ");
    }

}

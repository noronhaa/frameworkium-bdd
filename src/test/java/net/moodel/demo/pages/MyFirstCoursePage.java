package net.moodel.demo.pages;

import net.moodel.demo.utils.WebdriverUtils;
import com.frameworkium.pages.internal.BasePage;
import com.google.inject.Inject;
import com.frameworkium.tests.internal.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyFirstCoursePage extends BasePage<MyFirstCoursePage>{

    WebdriverUtils webdriverUtils;

    @Inject
    public MyFirstCoursePage() {
        webdriverUtils = new WebdriverUtils();
        org.openqa.selenium.support.PageFactory.initElements(BaseTest.getDriver(),this);
    }

    @FindBy(css = ".page-header-headings>h1")
    private WebElement title;

    public String getPageTitleText(){
        return webdriverUtils.getElementText(title);
    }

    public boolean amIonPage(){
        return webdriverUtils.getCurrentPageTitle().contains("Course: ");
    }

}

package net.moodel.demo.pages;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import net.moodel.demo.utils.WebdriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage<HomePage> {

    private WebdriverUtils webdriverUtils = new WebdriverUtils();

    @FindBy(css = ".page-header-headings>h1")
    private WebElement pageTitle;

    @FindBy(css = ".courses >div:first-of-type h3")
    private WebElement myFirstCourseLink;

    @FindBy(css = "h5 b")
    private WebElement homePageWelcomeText;

    @FindBy(linkText = "Edit settings")
    private WebElement editSettings;

    @FindBy(className = "usertext")
    private WebElement loggedInUserTab;


    public boolean isUserLoggedIn() {
        return webdriverUtils.isElementPresent(loggedInUserTab);
    }

    public MyFirstCoursePage clickMyFirstCourseLink() {
        webdriverUtils.click(myFirstCourseLink);
        return PageFactory.newInstance(MyFirstCoursePage.class);
    }

    public MyFirstCoursePage clickEditSettingsLink() {
        webdriverUtils.click(editSettings);
        return PageFactory.newInstance(MyFirstCoursePage.class);
    }

    public String getPageTitleText() {
        return webdriverUtils.getElementText(pageTitle);
    }


}

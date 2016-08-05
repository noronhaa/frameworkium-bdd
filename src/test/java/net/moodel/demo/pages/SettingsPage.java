package net.moodel.demo.pages;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import net.moodel.demo.utils.WebdriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage<SettingsPage> {

    WebdriverUtils webdriverUtils = new WebdriverUtils();

    @FindBy(css = ".page-header-headings>h1")
    private WebElement mainTitle;

    @FindBy(css = ".settingsform.clearfix h2")
    private WebElement subTitle;

    @FindBy(id = "id_s__fullname")
    private WebElement fullSiteNameField;

    @FindBy(css = ".form-submit")
    private WebElement saveButton;

    public boolean amIonPage() {
        return getPageTitleText().equals("Front page settings");
    }

    public String getPageTitleText() {
        return webdriverUtils.getElementText(subTitle);
    }

    public String getMainPageTitleText() {
        return webdriverUtils.getElementText(mainTitle);
    }

    public SettingsPage enterIntoFullSiteNameField(String text) {
        webdriverUtils.clearField(fullSiteNameField);
        webdriverUtils.enterIntoTextField(fullSiteNameField, text);
        return this;
    }

    public SettingsPage clickSaveButton() {
        webdriverUtils.click(saveButton);
        return PageFactory.newInstance(SettingsPage.class);
    }

}

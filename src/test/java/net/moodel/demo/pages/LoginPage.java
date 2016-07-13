package net.moodel.demo.pages;

import net.moodel.demo.utils.WebdriverUtils;
import com.frameworkium.pages.internal.BasePage;
import com.frameworkium.pages.internal.PageFactory;
import com.frameworkium.tests.internal.BaseTest;
import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage<LoginPage> {

    private WebElement username;
    private WebElement password;
    private WebElement loginbtn;

    @FindBy(css = ".error")
    private WebElement error;

    private static final String URL = "https://demo.moodle.net/login/index.php";

    private WebdriverUtils webdriverUtils;

    @Inject
    public LoginPage() {
        webdriverUtils = new WebdriverUtils();
        org.openqa.selenium.support.PageFactory.initElements(BaseTest.getDriver(),this);
    }

    public HomePage successfullyCompleteLoginPage(String username, String password){
        enterIntoUsernameField(username);
        enterIntoPasswordField(password);
        return clickLoginButton();
    }

    public HomePage clickLoginButton(){
        loginbtn.click();
        return PageFactory.newInstance(HomePage.class);
    }

    public LoginPage navigateToPage(){
        return PageFactory.newInstance(LoginPage.class,URL);
    }

    public void enterIntoUsernameField(String username){
        webdriverUtils.enterIntoTextField(this.username,username);
    }

    public void enterIntoPasswordField(String password){
        webdriverUtils.enterIntoTextField(this.password,password);
    }

}

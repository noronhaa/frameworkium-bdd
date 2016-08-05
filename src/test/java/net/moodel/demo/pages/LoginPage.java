package net.moodel.demo.pages;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import net.moodel.demo.utils.WebdriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage<LoginPage> {

    private static final String URL = "https://demo.moodle.net/login/index.php";
    private WebElement username;
    private WebElement password;
    private WebElement loginbtn;

    @FindBy(css = ".error")
    private WebElement error;
    private WebdriverUtils webdriverUtils = new WebdriverUtils();

    @Step("login with {0}:{1}")
    public HomePage successfullyCompleteLoginPage(String username, String password) {
        enterIntoUsernameField(username);
        enterIntoPasswordField(password);
        return clickLoginButton();
    }

    @Step
    public HomePage clickLoginButton() {
        loginbtn.click();
        return PageFactory.newInstance(HomePage.class);
    }

    public LoginPage navigateToPage() {
        return PageFactory.newInstance(LoginPage.class, URL);
    }

    public void enterIntoUsernameField(String username) {
        webdriverUtils.enterIntoTextField(this.username, username);
    }

    public void enterIntoPasswordField(String password) {
        webdriverUtils.enterIntoTextField(this.password, password);
    }

}

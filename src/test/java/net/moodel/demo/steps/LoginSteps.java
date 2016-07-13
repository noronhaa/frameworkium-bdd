package net.moodel.demo.steps;

import net.moodel.demo.pages.HomePage;
import net.moodel.demo.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Step Definition class for login related steps
 */
public class LoginSteps {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "sandbox";

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Given("^I have successfully logged in$")
    public void i_have_successfully_logged_in() throws Throwable {
        i_am_on_the_login_page();
        loginPage.successfullyCompleteLoginPage(CORRECT_USERNAME,CORRECT_PASSWORD);
        i_will_be_logged_in();
    }

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Throwable {
        loginPage.navigateToPage();
    }

    @When("^I submit login with incorrect details")
    public void i_enter_incorrect_login_details() throws Throwable {
        loginPage.enterIntoUsernameField(RandomStringUtils.randomAlphabetic(5));
        loginPage.enterIntoPasswordField(RandomStringUtils.randomAlphabetic(5));
        loginPage.clickLoginButton();
    }

    @When("^I submit login with correct details$")
    public void i_submit_login_with_correct_details() throws Throwable {
        loginPage.enterIntoUsernameField(CORRECT_USERNAME);
        loginPage.enterIntoPasswordField(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
    }

    @Then("^I will be logged in$")
    public void i_will_be_logged_in() throws Throwable {
        assertTrue("Not logged In", homePage.isUserLoggedIn());
    }

    @Then("^I will not be logged in$")
    public void i_will_not_be_not_be_logged_in() throws Throwable {
        assertFalse("user is logged in", homePage.isUserLoggedIn());

    }



}

package net.moodel.demo.steps;

import net.moodel.demo.pages.HomePage;
import net.moodel.demo.pages.MyFirstCoursePage;
import net.moodel.demo.pages.SettingsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Step Definition class for general steps and functionality
 */
public class StepDefs {

    private HomePage homePage;
    private MyFirstCoursePage myFirstCoursePage;
    private SettingsPage settingsPage;

    private String newTitle;

    public StepDefs() {
        homePage = new HomePage();
        myFirstCoursePage = new MyFirstCoursePage();
        settingsPage = new SettingsPage();
    }

    @Then("^I will be on the Course page")
    public void i_will_be_on_the_course_page() throws Throwable {
        assertTrue(myFirstCoursePage.amIonPage());
    }

    @Then("^the title '(.*)' will be present$")
    public void the_title_title_will_be_present(String expectedTitleText) throws Throwable {
        assertTrue(expectedTitleText.equals(myFirstCoursePage.getPageTitleText()));
    }

    @And("^I have navigated to the Settings page$")
    public void i_have_navigated_to_the_settings_page() throws Throwable {
        homePage.clickEditSettingsLink();
        assertTrue(settingsPage.amIonPage());
    }

    @When("^I click the My First Course link$")
    public void click_my_first_course_link() throws Throwable {
        homePage.clickMyFirstCourseLink();
    }

    @Then("^the home page title will be '(.*)'$")
    public void the_home_page_title_will_be_this_is_not_the_home_page_title(String titleText) throws Throwable {
//        throw new RuntimeException();
        assertEquals("Incorrect title",titleText,homePage.getPageTitleText());
    }

    @When("^I change the page title and submit$")
    public void enter_new_title_into_field_and_submit() throws Throwable {
        newTitle = "new page title with unique id: " + RandomStringUtils.randomAlphanumeric(5);
        settingsPage.enterIntoFullSiteNameField(newTitle);
        settingsPage.clickSaveButton();
    }

    @Then("^the new page title will be displayed$")
    public void the_new_page_title_will_be_displayed() throws Throwable {
        assertEquals("Incorrect title", newTitle, settingsPage.getMainPageTitleText());
    }




}

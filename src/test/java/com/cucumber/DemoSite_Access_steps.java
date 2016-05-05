package com.cucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.DashboardPage;
import pageObject.LoginPage;

import java.util.List;


public class DemoSite_Access_steps extends BaseSteps {

    WebDriver driver = super.getDriver();

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("^I have navigated to the Demo site$")
    public void shouldNavigateToTheDemoSite() throws Throwable {

        dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.navigateToDemoSite();
    }

    @When("^I log in with default credentials$")
    public void shouldLogInWithDefaultCredentials() throws Throwable {

        //all interaction to the page are driven from the steps file
        String defaultUsername = "brian@weconvene.com";
        String defaultPassword = "RobLia2016!";

        //every step ALWAYS news up a new page
        //don't worry about memory, it is cleared after every scenario
        //we never pass states of anything between scenarios

        //why is the return type of setting the username, still the login page?
        //because we are still on the page
        //only when we submit do we expect to get to the Dashboard
        //this also helps to read the scenario and plan it

        loginPage = new LoginPage(driver);
        loginPage = loginPage.setEmailAddress(defaultUsername);
        loginPage = loginPage.setPassword(defaultPassword);

        dashboardPage = loginPage.submitCredentials();
    }

    @Then("^I see the Dashboard$")
    public void checkOnDashboardPage() throws Throwable {

        //get the section title and assert that it is the dashboardPage
        dashboardPage = new DashboardPage(driver);

        String actualTitle = dashboardPage.getSectionTitle();
        String expectedTitle = "Dashboard";

        Assert.assertTrue("oops, this is not the dashboard", actualTitle.equals(expectedTitle));

    }

    @When("^I enter the username \"([^\"]*)\"$")
    public void shouldEnterUsername(String username) throws Throwable {

        loginPage = new LoginPage(driver);
        loginPage = loginPage.setEmailAddress(username);
    }

    @And("^I enter the password \"([^\"]*)\"$")
    public void shouldEnterPassword(String password) throws Throwable {

        loginPage = new LoginPage(driver);
        loginPage = loginPage.setPassword(password);
    }

    @And("^I click the Login button$")
    public void shouldClickLogin() throws Throwable {

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.submitCredentials();
    }

    @When("^I enter the username and password \"([^\"]*)\", \"([^\"]*)\"$")
    public void shouldEnterUsernameAndPassword(String username, String password) throws Throwable {

        loginPage = new LoginPage(driver);
        loginPage = loginPage.setEmailAddress(username);
        loginPage = loginPage.setPassword(password);
    }

    @When("^I login as user with username \"([^\"]*)\", and password \"([^\"]*)\"$")
    public void shouldLoginWithCredentials(String username, String password) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage = loginPage
                .setEmailAddress(username)
                .setPassword(password);

        dashboardPage = loginPage.submitCredentials();
    }

    @When("^I login with credentials$")
    public void shouldLoginWithCredentials(DataTable credentialsTable) throws Throwable {

        List<List<String>> credentials = credentialsTable.raw();

        //1st row is headers, so we don't want them - start our i counter at 1
        //username in 1st column - j=0
        //password in 2nd column - j=1

        String username = credentials.get(1).get(0);
        String password = credentials.get(1).get(1);

        loginPage = new LoginPage(driver);
        loginPage = loginPage
                .setEmailAddress(username)
                .setPassword(password);

        dashboardPage = loginPage.submitCredentials();
    }

    @When("^I login with \"([^\"]*)\"<password>$")
    public void iLoginWithPassword(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I try to log in$")
    public void shouldLoginExpectingError() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage = loginPage.submitCredentialsExpectingError();
    }

    @Then("^I see an error prompt with text \"([^\"]*)\"$")
    public void checkLoginErrorMessage(String expectedLoginErrorText) throws Throwable {

        loginPage = new LoginPage(driver);
        String actualLoginErrorText = loginPage.getLoginErrorMessage();

        Assert.assertTrue("oops, the login error message is wrong", actualLoginErrorText.equals(expectedLoginErrorText));
    }
}

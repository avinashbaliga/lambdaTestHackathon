package stepdefs.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.ManagePageObjects;
import org.openqa.selenium.WebDriver;
import utilities.BaseTest;
import utilities.ScenarioContext;

public class LoginStepdef extends BaseTest {

    private final ManagePageObjects managePageObjects;

    {
        managePageObjects = new ManagePageObjects((WebDriver) ScenarioContext.get("driver"));
    }

    @Given("I Open HerokuApp {string} page")
    public void iOpenHerokuAppLoginPage(String pageName) {
        log("Opening Heroku Login page");
        managePageObjects.getLoginPage().openHerokuAppLoginPage();
    }

    @And("I enter valid credentials")
    public void iEnterValidCredentials() {
        log("Entering username");
        managePageObjects.getLoginPage().enterValidUsername();

        log("Entering password");
        managePageObjects.getLoginPage().enterValidPassword();
    }

    @And("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        log("Entering invalid username");
        managePageObjects.getLoginPage().enterInvalidUsername();

        log("Entering invalid password");
        managePageObjects.getLoginPage().enterInvalidPassword();
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        log("Clicking on login button");
        managePageObjects.getLoginPage().clickOnLoginButton();
    }

    @Then("I should be able to login to the webapp with success message {string}")
    public void iShouldBeAbleToLoginToTheWebApp(String message) {
        log("Verifying login was successful");
        managePageObjects.getLoginPage().verifyLogin(message);
    }

    @Then("I should get the error message {string}")
    public void iShouldGetTheErrorMessage(String message) {
        log("Verifying the error message: '<span style = 'color:red'><b>" + message + "</b></span>' on entering invalid credentials");
        managePageObjects.getLoginPage().verifyLoginErrorMessage(message);
    }
}

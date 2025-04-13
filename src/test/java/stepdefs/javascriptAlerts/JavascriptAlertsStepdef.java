package stepdefs.javascriptAlerts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.ManagePageObjects;
import org.openqa.selenium.WebDriver;
import utilities.BaseTest;
import utilities.ScenarioContext;

public class JavascriptAlertsStepdef extends BaseTest {

    private ManagePageObjects managePageObjects;

    {
        managePageObjects = new ManagePageObjects((WebDriver) ScenarioContext.get("driver"));
    }

    @Given("I Open HerokuApp javascript_alerts page")
    public void iOpenJavascriptAlertsPage() {
        managePageObjects.getJavascriptAlertsPage().openJavaScriptAlertsPage();
    }

    @When("I click on {string} option in javascript alerts page")
    public void iClickOnOptionInJSAlertsPage(String option) {
        log("Click on option: " + option);
        managePageObjects.getJavascriptAlertsPage().selectJSAlertOption(option);
    }

    @Then("An alert should be displayed with message {string}")
    public void anAlertShouldBeDisplayed(String message) {
        log("Verify an alert/confirm/prompt is displayed");
        managePageObjects.getJavascriptAlertsPage().verifyJSAlertDisplayed(message);
    }

    @And("I should be able to close it on clicking OK button")
    public void closeTheAlert() {
        log("Closing the alert");
        managePageObjects.getJavascriptAlertsPage().closeAlert();
    }
}

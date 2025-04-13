package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.CommonWebUtility;

public class JavascriptAlertsPage extends CommonWebUtility {

    public JavascriptAlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Instead of writing a separate locator for each element, writing a generic method that can select any option passed
     */
    public void selectJSAlertOption(String option) {
        WebElement element = getElement(By.xpath("//button[text()='Click for " + option + "']"));
        clickOnElement(element);
    }

    public void verifyJSAlertDisplayed(String message) {
        Alert alert = switchToAlert();
        Assert.assertEquals(alert.getText().trim(), message);
    }

    public void closeAlert() {
        switchToAlert().accept();
    }

    public void openJavaScriptAlertsPage() {
        openHerokuAppPage("javascript_alerts");
    }
}

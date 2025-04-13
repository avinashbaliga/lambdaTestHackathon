package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonWebUtility {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public CommonWebUtility(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicitWaitTime"))));
    }

    public void sendKeys(WebElement element, String text) {
        waitForWebElementToBeVisible(element);
        element.sendKeys(text);
    }

    public void waitForWebElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element) {
        waitForWebElementToBeVisible(element);
        element.click();
    }

    public String getText(WebElement element) {
        waitForWebElementToBeVisible(element);
        return element.getText().trim();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement getElement(By xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public void openHerokuAppPage(String pageName) {
        openUrl(getPageUrl(pageName));
    }

    private String getPageUrl(String pageName) {
        return System.getProperty("url") + "/" + pageName;
    }
}

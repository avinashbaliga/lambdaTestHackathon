package objects;

import org.openqa.selenium.WebDriver;
import pages.JavascriptAlertsPage;
import pages.LoginPage;

/**
 * This is a singleton class responsible to return the object of a page
 */
public class ManagePageObjects {

    private final WebDriver driver;
    private LoginPage loginPage = null;
    private JavascriptAlertsPage javascriptAlertsPage = null;

    public ManagePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public JavascriptAlertsPage getJavascriptAlertsPage() {
        return (javascriptAlertsPage == null) ? javascriptAlertsPage = new JavascriptAlertsPage(driver) : javascriptAlertsPage;
    }
}

package pages;

import constants.CommonConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.CommonWebUtility;

public class LoginPage extends CommonWebUtility {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameTextBox;
    @FindBy(id = "password")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(id = "flash")
    private WebElement loginFlashMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterValidUsername() {
        enterUserName(CommonConstants.HEROKU_USERNAME);
    }

    public void enterValidPassword() {
        enterPassword(CommonConstants.HEROKU_PASSWORD);
    }

    public void enterInvalidUsername() {
        enterUserName(CommonConstants.HEROKU_USERNAME + "invalidUsername");
    }

    public void enterInvalidPassword() {
        enterPassword(CommonConstants.HEROKU_PASSWORD + "invalidPassword");
    }

    private void enterUserName(String username) {
        sendKeys(usernameTextBox, username);
    }

    private void enterPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public void verifyLogin(String expectedSuccessMessage) {
        verifyFlashMessageForLogin(expectedSuccessMessage);
    }

    public void verifyLoginErrorMessage(String expectedErrorMessage) {
        verifyFlashMessageForLogin(expectedErrorMessage);
    }

    private void verifyFlashMessageForLogin(String expectedSuccessMessage) {
        String actualLoginMessage = getText(loginFlashMessage);
        Assert.assertTrue(actualLoginMessage.contains(expectedSuccessMessage),
                "Expected login message: \n" + expectedSuccessMessage + "But found: \n" + actualLoginMessage);
    }

    public void openHerokuAppLoginPage() {
        openHerokuAppPage("login");
    }
}

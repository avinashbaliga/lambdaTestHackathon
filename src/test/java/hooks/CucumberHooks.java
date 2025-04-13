package hooks;

import constants.CommonConstants;
import exceptions.BrowserNotSupportedException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ScenarioContext;

import java.net.MalformedURLException;
import java.net.URL;

public class CucumberHooks {

    private WebDriver driver = null;

    @Before
    public void setUp() {
        createWebDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed())
            scenario.attach(((TakesScreenshot) ScenarioContext.get("driver")).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
    }

    @After
    public void tearDown(){
        closeBrowserInstance();
    }

    private void closeBrowserInstance() {
        driver.quit();
        driver = null;
    }

    private WebDriver createWebDriver() {
        initializeWebDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private void initializeWebDriver() {
        if (CommonConstants.EXECUTION_PLATFORM.equalsIgnoreCase("local"))
            createLocalDriver();
        else createRemoteDriver();
        ScenarioContext.set("driver", driver);
    }

    private void createRemoteDriver() {
        try {
            driver = new RemoteWebDriver(new URL(getRemoteUrl()), getCapabilities(System.getProperty("buildName")));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void createLocalDriver() {
        driver = switch (CommonConstants.BROWSER) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default ->
                    throw new BrowserNotSupportedException("Browser : '" + CommonConstants.BROWSER + "' is not supported");
        };
    }

    private DesiredCapabilities getCapabilities(String buildName) {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.BROWSER_NAME, CommonConstants.BROWSER);
//        capability.setCapability("build", buildName); This doesn't work as of now since Chrome 75+ forces w3c standards
//        return updateCapabilityWithExperimentalFeature(browserName, capability);

        return capability;
    }

    /**
     * This code is used to set experimental option. However, Chrome 75+ enforces w3c standards and this gets ignored during runtime.
     * private DesiredCapabilities updateCapabilityWithExperimentalFeature(String browser, DesiredCapabilities capabilities) {
     * switch (browser) {
     * case "chrome":
     * ChromeOptions chromeOptions = new ChromeOptions();
     * chromeOptions.setExperimentalOption("w3c", true);
     * capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
     * break;
     * case "edge":
     * EdgeOptions edgeOptions = new EdgeOptions();
     * edgeOptions.setExperimentalOption("w3c", true);
     * capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
     * break;
     * default:
     * throw new BrowserNotSupportedException(browser + " browser is not supported.");
     * }
     * <p>
     * return capabilities;
     * }
     */


    private String getRemoteUrl() {
        return "https://" + System.getProperty("lambdaTestUsername") + ":" + System.getProperty("lambdaTestAccessKey") + "@hub.lambdatest.com/wd/hub";
    }
}

package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.CommonConstants;
import exceptions.BrowserNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private Logger logger = null;
    private static ExtentReports extentReports;

    static {
        extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentSparkReporter(CommonConstants.TEST_REPORT_PATH);
        extentReports.attachReporter((ExtentObserver) extentReporter);
    }

    public void log(String message) {
        initializeLogger();
        logger.info(message);
    }

    private void initializeLogger() {
        if (logger == null)
            logger = LogManager.getLogger(this);
    }
}

package constants;

public class CommonConstants {

    public static final String EXECUTION_PLATFORM = System.getProperty("executionPlatform");
    public static final String BROWSER = System.getProperty("browser");
    public static final String HEROKU_USERNAME = System.getProperty("loginUsername");
    public static final String HEROKU_PASSWORD = System.getProperty("loginPassword");
    public static final String TEST_REPORT_PATH = "target/test_report.html";
}

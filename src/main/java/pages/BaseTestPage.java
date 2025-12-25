package pages;

import drivers.DriverFactory;
import drivers.DriverManagerFactory;
import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;

public class BaseTestPage {
    protected WebDriver driver;
    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("beforeSuite - Init extent Report");
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    public void beforeClass() {
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        DriverFactory.setDriver(driver);
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());

    }

    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        LOG.info("Test Complete");
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(driver, result.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports();
    }
}

package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC22_VerifyNavigateToRegisterPage extends BaseTestPage {
    @Test(description = "Login Test 21 - Verify Naviagtion to Register Page from Login Page ")
    public void testLogin21() {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 1: Navigate to Register Page from Login Page");
        LOG.info("Step 1: Navigate to Register Page from Login Page");
        loginPage.clickRegisterLink();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://demo1.cybersoft.edu.vn/sign-up";
        Assert.assertEquals(actualURL, expectedURL, "User is not navigated to Register Page");
        ExtentReportManager.pass("PASSED");
    }
}

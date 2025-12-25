package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC11_VerifyNavigateToProfilePage extends BaseTestPage {
    @Test(description = "Login Test 11 - Profile Navigation to Profile Page")
    public void testLogin11() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step1: nhập acc");
        LOG.info("Step1: nhập acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60"; //exist account
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 2: Enter password to login");
        LOG.info("Step 2: Enter password to login");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 3: Click Login");
        LOG.info("Step 3: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("Step 4: Navigate to Profile Page");
        LOG.info("Step 4: Navigate to Profile Page");
        loginPage.clickProfile();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demo1.cybersoft.edu.vn/account", currentUrl);
        ExtentReportManager.pass("PASSED");
    }
}

package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC17_VerifyEyePassword extends BaseTestPage {
    @Test(description = "ProfilePage Test 17 - Verify eye password button functionality")
    public void testCase17() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step 1: Login");
        LOG.info("Step 1: Login");
        String account = "d412f56f";
        loginPage.enterAccount(account);
        loginPage.enterPassword("NewPass123@");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Navigate to Profile Page");
        LOG.info("Step 2: Navigate to Profile Page");
        loginPage.clickProfile();

        ExtentReportManager.info("Verify Point 1: Eye Password button is set to hide password by default");
        LOG.info("Verify Point 1: Eye Password button is set to hide password by default");
        String passwordFieldType = profilePage.getPasswordFieldType();
        Assert.assertEquals(passwordFieldType, "password", "Password field is not set to hide password by default");

        ExtentReportManager.info("Step 3: Click Eye Password button");
        LOG.info("Step 3: Click Eye Password button");
        profilePage.clickEyePassword();

        ExtentReportManager.info("Verify Point 2: Password is displayed in plain text after clicking Eye Password button");
        LOG.info("Verify Point 2: Password is displayed in plain text after clicking Eye Password button");
        String passwordFieldTypeAfterClick = profilePage.getPasswordFieldType();
        Assert.assertEquals(passwordFieldTypeAfterClick, "text", "Password field is not displaying password in plain text after clicking Eye Password button");
    }
}

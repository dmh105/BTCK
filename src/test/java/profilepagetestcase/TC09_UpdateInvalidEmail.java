package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC09_UpdateInvalidEmail extends BaseTestPage {
    @Test(description = "ProfilePage Test 09 - Update with invalid email data")
    public void testCase09() throws InterruptedException {
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

        ExtentReportManager.info("Step 3: CLear Email on Profile Page");
        LOG.info("Step 3: CLear Email on Profile Page");
        profilePage.clearEmail();

        ExtentReportManager.info("Step 4: Enter invalid Email on Profile Page");
        LOG.info("Step 4: Enter invalid Email on Profile Page");
        profilePage.enterEmail("d412f56f-feae-459f-9133-85a3f1cc7295@example.comf13d5807-354b-45e0-9b8a-f1311673c74a@example.com");

        ExtentReportManager.info("Step 5: Click Update button");
        LOG.info("Step 5: Click Update button");
        profilePage.clickUpdate();

        ExtentReportManager.info("Verify Point 1: Validation message for invalid email data");
        LOG.info("Verify Point 1: Validation message for invalid email data");
        String actualEmailValidationMsg = profilePage.getUpdateMessage();
        Assert.assertEquals(actualEmailValidationMsg, "Dữ liệu không hợp lệ!");
    }
}

package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC02_VerifyDisplayInfo extends BaseTestPage {
    @Test(description = "ProfilePage Test 2 - Display user information correctly on Profile Page - Registered name John A")
    public void testDisplayUserInfoOnProfilePage() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 2: Enter acc");
        LOG.info("Step2: Enter acc");
        String account = "2c89469e";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password");
        LOG.info("Step 3: nhập password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 5: Navigate to Profile Page");
        LOG.info("Step 5: Navigate to Profile Page");
        loginPage.clickProfile();

        ExtentReportManager.info("Step 6: Verify user information is displayed correctly on Profile Page");
        LOG.info("Step 6: Verify user information is displayed correctly on Profile Page");
        String expectedAccName = "2c89469e";
        String expectedFullName = "cefbabbfccd";
        String expectedEmail = "2c89469e-0858-47f5-b956-7ab4bfc605cd@example.com";
        String expectedPhoneNumber = "";
        String expectedPassword = "Test123456@";
        Assert.assertEquals(profilePage.getAccName(), expectedAccName, "Account Name does not match");
        Assert.assertEquals(profilePage.getFullName(), expectedFullName, "Full Name does not match");
        Assert.assertEquals(profilePage.getEmail(), expectedEmail, "Email does not match");
        Assert.assertEquals(profilePage.getPhoneNumber(), expectedPhoneNumber, "Phone Number does not match");
        Assert.assertEquals(profilePage.getPassword(), expectedPassword, "Password does not match");
        ExtentReportManager.pass("PASSED");
    }
}

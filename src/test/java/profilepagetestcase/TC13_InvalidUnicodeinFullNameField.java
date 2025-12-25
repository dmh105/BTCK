package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC13_InvalidUnicodeinFullNameField extends BaseTestPage {
    @Test(description = "ProfilePage Test 13 - Update with invalid fullname data")
    public void testCase13() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        String emojiCode = "1F600"; // Unicode code point for 😀

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

        ExtentReportManager.info("Step 3: CLear Full Name on Profile Page");
        LOG.info("Step 3: CLear Full Name on Profile Page");
        profilePage.clearFullName();

        ExtentReportManager.info("Step 4: Enter invalid Full Name on Profile Page");
        LOG.info("Step 4: Enter invalid Full Name on Profile Page");
        profilePage.sendEmojiToFullName(driver, emojiCode);

        ExtentReportManager.info("Step 5: Click Update button");
        LOG.info("Step 5: Click Update button");
        profilePage.clickUpdate();

        ExtentReportManager.info("Verify Point 1: Validation message for invalid fullname data");
        LOG.info("Verify Point 1: Validation message for invalid fullname data");
        String actualFullNameValidationMsg = profilePage.getFullNameValidationMessage();
        Assert.assertEquals(actualFullNameValidationMsg, "Đây là trường bắt buộc !");
    }
}

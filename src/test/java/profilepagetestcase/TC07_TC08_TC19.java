package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC07_TC08_TC19 extends BaseTestPage {
    @Test(description = "ProfilePage Test 07 - TC08 - TC19")
    public void testCase() throws InterruptedException {
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

        ExtentReportManager.info("Step 3: CLear all data on Profile Page");
        LOG.info("Step 3: CLear all data on Profile Page");
        profilePage.clearPassword();
        profilePage.clearFullName();
        profilePage.clearPhoneNumber();

        ExtentReportManager.info("Step 4: Enter invalid data on Profile Page");
        LOG.info("Step 4: Enter invalid data on Profile Page");
        profilePage.enterPassword("123");
        profilePage.enterFullName("14789");
        profilePage.enterPhoneNumber("abcd");

        ExtentReportManager.info("Step 5: Click Update button");
        LOG.info("Step 5: Click Update button");
        profilePage.clickUpdate();

        ExtentReportManager.info("Verify Point 1: Validation message for invalid data");
        LOG.info("Verify Point 1: Validation message for invalid data");
        String actualPasswordValidationMsg = profilePage.getPasswordValidationMessage();
        String actualFullNameValidationMsg = profilePage.getFullNameValidationMessage();
        String actualPhoneNumberValidationMsg = profilePage.getPhoneNumberValidationMessage();
        //Test
        Assert.assertEquals(actualPasswordValidationMsg, "Mật khẩu phải có ít nhất 6 kí tự !");
        Assert.assertEquals(actualFullNameValidationMsg, "Họ và tên không chứa số !");
        Assert.assertEquals(actualPhoneNumberValidationMsg, "Vui lòng nhập số điện thoại");

    }
}

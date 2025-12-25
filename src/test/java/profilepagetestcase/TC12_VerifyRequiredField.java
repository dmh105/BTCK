package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC12_VerifyRequiredField extends BaseTestPage {
    @Test(description = "ProfilePage Test 12 - Invalid Update when leaving all fields blank on Profile Page" +
            "and display validation messages")
    public void testCase11() throws InterruptedException {
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

        ExtentReportManager.info("Step 3: delete deletable fields on Profile Page");
        LOG.info("Step 3: Clear all fields on Profile Page");
        profilePage.clearPassword();
        profilePage.clearEmail();
        profilePage.clearFullName();
        profilePage.clearPhoneNumber();

        ExtentReportManager.info("Step 4: Click Update button");
        LOG.info("Step 4: Click Update button");
        profilePage.clickUpdate();

        ExtentReportManager.info("Verify Point 1: Validation message for empty field");
        LOG.info("Verify Point 1: Validation message for empty field");
        String actualPasswordValidationMsg = profilePage.getPasswordValidationMessage();
        String actualEmailValidationMsg = profilePage.getEmailValidationMessage();
        String actualFullNameValidationMsg = profilePage.getFullNameValidationMessage();
        String actualPhoneNumberValidationMsg = profilePage.getPhoneNumberValidationMessage();
        //Test
        Assert.assertEquals(actualEmailValidationMsg, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualFullNameValidationMsg, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualPasswordValidationMsg, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualPhoneNumberValidationMsg, "Vui lòng nhập số điện thoại");
    }
}

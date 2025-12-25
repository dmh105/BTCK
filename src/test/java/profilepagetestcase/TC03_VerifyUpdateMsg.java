package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

import java.util.UUID;

@Listeners(TestListeners.class)
public class TC03_VerifyUpdateMsg extends BaseTestPage {
    @Test(description = "ProfilePage Test 03 - Update All user information on Profile Page")
    public void testUpdateAllUserInfoOnProfilePage() throws InterruptedException {
        String a = UUID.randomUUID().toString();
        String regex = "[0-9-]+";
        String FullName = a.replaceAll(regex, "");
        String newEmail = a + "@example.com";
        String newPhoneNumber = "0123456789";
        String newPassword = a.substring(0, 13).replace("-", "");

        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step 1: Enter acc");
        LOG.info("Step2: Enter acc");
        String account = "02206ab7";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 2: Enter password");
        LOG.info("Step 3: Enter password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 3: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 4: Navigate to Profile Page");
        LOG.info("Step 5: Navigate to Profile Page");
        loginPage.clickProfile();

        ExtentReportManager.info("Step 5: Update user information on Profile Page");
        LOG.info("Step 6: Update user information on Profile Page");

        ExtentReportManager.info("Update Email");
        LOG.info("Update Email");
        profilePage.clickEmail();
        profilePage.clearEmail();
        profilePage.enterEmail(newEmail);


        ExtentReportManager.info("Update Full Name");
        LOG.info("Update Full Name");
        profilePage.clickFullName();
        profilePage.clearFullName();
        profilePage.enterFullName(FullName);

        ExtentReportManager.info("Update Password");
        LOG.info("Update Password");
        profilePage.clickEyePassword();
        profilePage.clickPassword();
        profilePage.clearPassword();
        profilePage.enterPassword(newPassword);


        ExtentReportManager.info("Update Phone Number");
        LOG.info("Update Phone Number");
        profilePage.clickPhoneNumber();
        profilePage.clearPhoneNumber();
        profilePage.enterPhoneNumber(newPhoneNumber);

        ExtentReportManager.info("Click Update button");
        LOG.info("Click Update button");
        profilePage.clickUpdate();
        String updateMsg = profilePage.getUpdateMessage();

        ExtentReportManager.info("Step 6: Verify user information is updated successfully on Profile Page");
        LOG.info("Step 7: Verify user information is updated successfully on Profile Page");
        Assert.assertEquals(updateMsg, "Cập nhật thành công", "Update success message does not match");
        Assert.assertEquals(profilePage.getFullName(), FullName, "Full Name was not updated correctly");
        Assert.assertEquals(profilePage.getEmail(), newEmail, "Email was not updated correctly");
        Assert.assertEquals(profilePage.getPhoneNumber(), newPhoneNumber, "Phone Number was not updated correctly");
        Assert.assertEquals(profilePage.getPassword(), newPassword, "Password was not updated correctly");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
        //reset password
        profilePage.closeBtnCloseUpdateMsg();
        Thread.sleep(5000);
        loginPage.clickSignOut();
        loginPage.clickConfirmLogout();
        Thread.sleep(5000);
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        loginPage.enterAccount(account);
        loginPage.enterPassword(newPassword);
        loginPage.clickLogin();
        Thread.sleep(5000);
        loginPage.clickProfile();
        Thread.sleep(5000);
        profilePage.clickEyePassword();
        profilePage.clickPassword();
        profilePage.clearPassword();
        profilePage.enterPassword("Test123456@");
        profilePage.clickUpdate();
        Thread.sleep(5000);
        ExtentReportManager.info("Reset password to original");
        LOG.info("Reset password to original");

    }

}

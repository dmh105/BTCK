package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

import java.util.UUID;

@Listeners(TestListeners.class)
public class TC04_VerifyUpdateField extends BaseTestPage {
    @Test(description = "ProfilePage Test 04 - Update 1 field of user information on Profile Page")
    public void testUpdateUserInfoOnProfilePageInvalid() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        String a = UUID.randomUUID().toString();
        String regex = "[0-9-]+";
        String FullName = a.replaceAll(regex, "");
        String newFullName = FullName;

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

        ExtentReportManager.info("Step 3: Update FullName field on Profile Page");
        LOG.info("Step 3: Update FullName field on Profile Page");
        profilePage.clearFullName();
        profilePage.enterFullName(newFullName);

        ExtentReportManager.info("Step 4: Click Update button");
        LOG.info("Click Update button");
        profilePage.clickUpdate();
        String updateMsg = profilePage.getUpdateMessage();

        //Test
        Assert.assertEquals(updateMsg, "Cập nhật thành công", "Update user information failed!");
    }
}

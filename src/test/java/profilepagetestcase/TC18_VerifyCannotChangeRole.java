package profilepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC18_VerifyCannotChangeRole extends BaseTestPage {
    @Test(description = "ProfilePage Test 18 - Verify customer role cannot be changed")
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

        ExtentReportManager.info("Verify Point 1: Role option cannot be changed");
        LOG.info("Verify Point 1: Role option cannot be changed");
        profilePage.selectRoleByIndex(1);
        String selectedRole = profilePage.getRoleSelectedOption();
        Assert.assertEquals(selectedRole, "Khách Hàng", "Role option should not be changed from 'Khách hàng'");

        ExtentReportManager.info("Verify Point 2: Dropdown option cannot be changed");
        LOG.info("Verify Point 2: Dropdown option cannot be changed");
        boolean isDisabled = profilePage.checkDropdownRoleIsDisabled();
        Assert.assertFalse(isDisabled, "Role dropdown should be disabled for customer role");

        ExtentReportManager.info("Passed");
    }
}

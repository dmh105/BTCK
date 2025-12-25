package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC05_VerifyLoginOnlyPass extends BaseTestPage {
    @Test(description = "Login Test 04")
    public void testLogin04() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step 1: Enter password");
        LOG.info("Step 1: Enter password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 2: Press Enter");
        LOG.info("Step 2: Press Enter");
        loginPage.pressEnterToLogin();

        ExtentReportManager.info("VP1: Required message displays");
        LOG.info("VP1: Required message displays");

        String actualRequiredMsg = loginPage.getRequiredAccountMsg();
        Assert.assertEquals(actualRequiredMsg, "Đây là trường bắt buộc !", "FAIL");
        ExtentReportManager.pass("PASSED");
    }
}

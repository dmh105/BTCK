package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC04_LoginOnlyAcc extends BaseTestPage {
    @Test(description = "Login Test 03 - Login with empty account and password")
    public void testLogin03() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step 1: Enter acc");
        LOG.info("Step 1: Enter acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);


        ExtentReportManager.info("Step 2: Press Enter");
        LOG.info("Step 2: Press Enter");
        loginPage.pressEnterToLogin();

        ExtentReportManager.info("VP1: Required message displays");
        LOG.info("VP1: Required message displays");

        String actualRequiredMsg = loginPage.getRequiredPasswordMsg();
        Assert.assertEquals(actualRequiredMsg, "Đây là trường bắt buộc !", "FAIL");
        ExtentReportManager.pass("PASSED");
    }
}

package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC09_VerifyLogoutSuccess extends BaseTestPage {
    @Test(description = "Login Test 08 - Đăng xuất thành công")
    public void testLogin08() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Step1: click đăng nhập link on top right");
        LOG.info("Step1: click đăng nhập link on top right");
        homePage.getTopBarNavigation().navigateLoginPage();
        ExtentReportManager.info("Step2: Enter acc");
        LOG.info("Step2: Enter acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60"; //exist account
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: Enter password to login");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();
        ExtentReportManager.info("VP1: 'Đăng nhập thành công' message displays");
        LOG.info("VP1: 'Đăng nhập thành công' message displays");

        ExtentReportManager.info("Step 5: Đăng xuất");
        LOG.info("Step 5: Đăng xuất");
        loginPage.clickSignOut();
        ExtentReportManager.info("Step 6: Xác nhận đăng xuất");
        LOG.info("Step 6: Xác nhận đăng xuất");
        loginPage.clickConfirmLogout();
        String actualLogoutMsg = loginPage.getLogoutSuccessMsg();
        Assert.assertEquals(actualLogoutMsg, "Đã đăng xuất");
        ExtentReportManager.pass("PASSED");
    }
}

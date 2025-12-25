package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC07_VerifyMsgWrongAccPass extends BaseTestPage {
    @Test(description = "Login Test 06 - Đăng nhập với tài khoản sai mật khẩu")
    public void testLogin06() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step1: click đăng nhập link on top right");
        LOG.info("Step1: click đăng nhập link on top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step2: nhập acc");
        LOG.info("Step2: nhập acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: Enter password to login");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("VP1: 'Đăng nhập không thành công' message displays");
        LOG.info("VP1: 'Đăng nhập không thành công' message displays");
        String actualLoginMsg = loginPage.getErrorLoginMsg();
        Assert.assertEquals(actualLoginMsg, "Tài khoản hoặc mật khẩu không đúng!", "Test Passed!");
        ExtentReportManager.pass("PASSED");
    }
}

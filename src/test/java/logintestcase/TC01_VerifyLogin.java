package logintestcase;

import listeners.TestListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC01_VerifyLogin extends BaseTestPage {
    @Test(description = "Login Test 01 - Successful Login with valid account")
    public void testLogin() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Step 1: click đăng nhập link on top right");
        LOG.info("Step1: click đăng nhập link on top right");
        homePage.getTopBarNavigation().navigateLoginPage();


        ExtentReportManager.info("Step 2: Enter acc");
        LOG.info("Step2: Enter acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password");
        LOG.info("Step 3: nhập password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("VP1: 'Đăng nhập thành công' message displays");
        LOG.info("VP1: 'Đăng nhập thành công' message displays");
        String actualLoginMsg = loginPage.getLoginMsg();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "FAIL");
        ExtentReportManager.pass("PASSED");
    }
}

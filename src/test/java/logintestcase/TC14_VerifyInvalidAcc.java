package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC14_VerifyInvalidAcc extends BaseTestPage {
    @Test(description = "Login Test 14 - Xác minh không chấp nhận nhập tài khoản có khoảng trắng ở giữa")
    public void testLogin14() {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 1: nhập acc có khoảng trắng giữa dòng");
        LOG.info("Step2: nhập acc");
        String account = "d75fe03d-ef 7b-4d9b-b2ec-9fe85f72ac60 ";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: Enter password to login");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("VP1: 'Tài khoản hoặc mật khẩu không đúng!' message displays");
        LOG.info("VP1: 'Tài khoản hoặc mật khẩu không đúng!' message displays");
        String actualErrorLoginMsg = loginPage.getErrorLoginMsg();
        Assert.assertEquals(actualErrorLoginMsg, "Tài khoản hoặc mật khẩu không đúng!", "Error login message is displayed as expected!");
    }
}

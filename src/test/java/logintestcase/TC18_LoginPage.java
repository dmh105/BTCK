package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC18_LoginPage extends BaseTestPage {
    @Test(description = "Login Test 18 - Xác minh không chấp nhận nhập ký tự đặc biệt trong trường mật khẩu")
    public void testLogin18() {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 1: nhập acc");
        LOG.info("Step2: nhập acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password có ký tự đặc biệt");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456@❤");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("VP1: 'Tài khoản hoặc mật khẩu không đúng!' message displays");
        LOG.info("VP1: 'Tài khoản hoặc mật khẩu không đúng!' message displays");
        String actualErrorLoginMsg = loginPage.getErrorLoginMsg();
        Assert.assertEquals(actualErrorLoginMsg, "Tài khoản hoặc mật khẩu không đúng!", "Error login message is displayed as expected!");
    }

}

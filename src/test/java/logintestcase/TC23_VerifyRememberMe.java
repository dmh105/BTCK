package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC23_VerifyRememberMe extends BaseTestPage {
    @Test(description = "Login Test 23 - Remember Me ")
    public void testLogin20() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 1: nhập acc");
        LOG.info("Step2: nhập acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Remember Me");
        LOG.info("Step 5: Click Remember Me");
        loginPage.clickRememberMe();

        ExtentReportManager.info("Step 5: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        Thread.sleep(5000);

        ExtentReportManager.info("Step 6: Đăng xuất");
        LOG.info("Step 5: Đăng xuất");
        loginPage.clickSignOut();

        ExtentReportManager.info("Step 6: Xác nhận đăng xuất");
        LOG.info("Step 6: Xác nhận đăng xuất");
        loginPage.clickConfirmLogout();

        Thread.sleep(3000);
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step 7: Kiểm tra thông tin tài khoản đã được ghi nhớ");
        LOG.info("Step 7: Kiểm tra thông tin tài khoản đã được ghi nhớ");
        String actualAccount = loginPage.getAccountFieldValue();
        String actualPassword = loginPage.getPasswordFieldValue();
        Assert.assertEquals(actualAccount, account);
        Assert.assertEquals(actualPassword, "Test123456@");
        ExtentReportManager.pass("PASSED");
    }
}

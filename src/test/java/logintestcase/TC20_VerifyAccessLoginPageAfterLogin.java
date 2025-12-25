package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC20_VerifyAccessLoginPageAfterLogin extends BaseTestPage {
    @Test(description = "Login Test 20 - sau khi đăng nhập có vào được trang login ")
    public void testLogin20() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        ExtentReportManager.info("Step 1: Enter acc");
        LOG.info("Step2: Enter acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password");
        LOG.info("Step 3: Enter password to login");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();
        Thread.sleep(5000);
        ExtentReportManager.info("Step 5: Sau khi đăng nhập vào lại trang login");
        LOG.info("Step 5: Sau khi đăng nhập vào lại trang login");
        driver.navigate().to("https://demo1.cybersoft.edu.vn/sign-in");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo1.cybersoft.edu.vn/", "User is redirected to home page instead of login page");
        ExtentReportManager.pass("PASSED");
    }
}


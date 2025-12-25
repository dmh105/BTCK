package logintestcase;

import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC12_VerifyNavigateToLoginPage extends BaseTestPage {
    @Test(description = "Login Test 12 - Dán URL đã đăng nhập vào tab ẩn danh")
    public void testLogin12() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);
        loginPage.enterPassword("Test123456@");

        loginPage.clickLogin();
        Thread.sleep(5000);
        loginPage.clickProfile();
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        ExtentReportManager.info("Current URL after login: " + url);
        LOG.info("Current URL after login: " + url);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver incognitoDriver = new ChromeDriver(options);
        incognitoDriver.manage().window().maximize();
        incognitoDriver.get(url);

        Thread.sleep(10000);

        String incognitoUrl = incognitoDriver.getCurrentUrl();
        ExtentReportManager.info("URL in incognito mode: " + incognitoUrl);
        LOG.info("URL in incognito mode: " + incognitoUrl);
        Assert.assertEquals("https://demo1.cybersoft.edu.vn/sign-in", incognitoUrl);
        incognitoDriver.quit();
    }
}

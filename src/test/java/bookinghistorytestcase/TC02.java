package bookinghistorytestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import pages.RegisterPage;
import reports.ExtentReportManager;

import java.util.UUID;

@Listeners(TestListeners.class)
public class TC02 extends BaseTestPage {
    @Test(description = "Show empty history of booking of new account on Profile Page")
    public void testCase2() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        HomePage homePage = new HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Verify Point 1: Register successfully");
        LOG.info("Verify Point 1: Register successfully");
        ExtentReportManager.info("Step 1: Click link 'Đăng Ký'");

        LOG.info("Step 1: Click link 'Đăng Ký'");
        homePage.getTopBarNavigation().navigateRegisterPage();

        ExtentReportManager.info("Step 2: Enter account");
        LOG.info("Step 2: Enter account");

        String account = UUID.randomUUID().toString();
        String delimiter = "-";
        String[] parts = account.split(delimiter);
        String firstPart = parts[0];
        registerPage.enterAcc(firstPart);

        ExtentReportManager.info("Step 3: Enter password");
        LOG.info("Step 3: Enter password");
        registerPage.enterPass("Test123456@");

        ExtentReportManager.info("Step 4: Enter confirm password");
        LOG.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPass("Test123456@");

        ExtentReportManager.info("Step 5: Enter name");
        LOG.info("Step 5: Enter name");
        String regex = "[0-9-]+";
        String Name = account.replaceAll(regex, "");
        registerPage.enterName(Name);

        ExtentReportManager.info("Step 6: Enter email");
        LOG.info("Step 6: Enter email");
        String email = account + "@example.com";
        registerPage.enterEmail(email);

        ExtentReportManager.info("Step 7: Click register button");
        LOG.info("Step 7: Click register button");
        registerPage.clickRegister();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 8 Verify user register login successfully");
        LOG.info("Step 8 Verify user register login successfully");
        registerPage.saveAccountInfo(firstPart, "Test123456@", Name, email);

        ExtentReportManager.info("Verify Point 2: History of booking is empty");
        LOG.info("Verify Point 2: History of booking is empty");
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step 9: Login with newly registered account");
        LOG.info("Step 9: Login with newly registered account");
        loginPage.enterAccount(firstPart);
        loginPage.enterPassword("Test123456@");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 10: Navigate to Profile Page");
        LOG.info("Step 10: Navigate to Profile Page");
        loginPage.clickProfile();
        Thread.sleep(5000);

        int bookingCount = profilePage.getAllBookingItems();
        Assert.assertEquals(0, bookingCount, "Booking history is not empty for new account.");
    }
}

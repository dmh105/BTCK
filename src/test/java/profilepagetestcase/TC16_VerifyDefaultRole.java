package profilepagetestcase;

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
public class TC16_VerifyDefaultRole extends BaseTestPage {
    @Test(description = "ProfilePage Test 16 - Verify default role is customer on Profile Page")
    public void testCase16() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        HomePage homePage = new HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Verify Point 1 : Register account");
        LOG.info("Verify Point 1 : Register account");
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

        registerPage.saveAccountInfo(firstPart, "Test123456@", Name, email);

        ExtentReportManager.info("Verify Point 2 : Login");
        LOG.info("Verify Point 2 : Login");
        pages.LoginPage loginPage = new pages.LoginPage();
        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step 8: Enter account");
        LOG.info("Step 8: Enter account");
        loginPage.enterAccount(firstPart);

        ExtentReportManager.info("Step 9: Enter password");
        LOG.info("Step 9: Enter password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 10: Click Login");
        LOG.info("Step 10: Click Login");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 11: Navigate to Profile Page");
        LOG.info("Step 11: Navigate to Profile Page");
        loginPage.clickProfile();

        ExtentReportManager.info("Verify Point 3: Default role is customer on Profile Page");
        LOG.info("Verify Point 3: Default role is customer on Profile Page");
        pages.ProfilePage profilePage = new pages.ProfilePage();
        String actualRole = profilePage.getRoleSelectedOption();
        String expectedRole = "Khách Hàng";
        Assert.assertEquals(actualRole, expectedRole, "Default role is not customer on Profile Page");
    }
}

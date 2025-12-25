package registertestcase;

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
public class TC10_VerifyMsgSuccess extends BaseTestPage {
    @Test(description = "RegisterPage Test 10 - Successful Register")
    public void testCase10() {
        RegisterPage registerPage = new RegisterPage();
        HomePage homePage = new HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/");

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

        ExtentReportManager.info("Step 8 Verify user register login successfully");
        LOG.info("Step 8 Verify user register login successfully");
        //VP1: display message
        LOG.info("VP1: display message");
        String actualRegisterMsg = registerPage.getRegisterMessage();
        registerPage.saveAccountInfo(firstPart, "Test123456@", Name, email);
        //VP2: Check new acc login successfully
        LOG.info("VP2: Check new acc login successfully");
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register Fail");

    }
}

package registertestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC05_VerifyEyePassword extends BaseTestPage {
    @Test(description = "RegisterPage Test 5 - Eye Password Functionality ")
    public void testEyePassword() {
        pages.RegisterPage registerPage = new pages.RegisterPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        homePage.getTopBarNavigation().navigateRegisterPage();

        ExtentReportManager.info("Step1: Enter password and confirm password");
        LOG.info("Step1: Enter password and confirm password");
        registerPage.enterPass("Test123456@");
        registerPage.enterConfirmPass("Test123456@");

        ExtentReportManager.info("Verify Point 1: Password field type is 'password'");
        LOG.info("Verify Point 1: Password field type is 'password'");
        String fieldType = registerPage.getPasswordFieldType();
        Assert.assertEquals(fieldType, "password");

        ExtentReportManager.info("Step 2: Click Eye Password");
        LOG.info("Step 2: Click Eye Password");
        registerPage.clickEyePassword();

        ExtentReportManager.info("Verify Point 2: Password field type is 'text' after clicking eye icon");
        LOG.info("Verify Point 2: Password field type is 'text' after clicking eye icon");
        String fieldTypeAfterClick = registerPage.getPasswordFieldType();
        Assert.assertEquals(fieldTypeAfterClick, "text");

        ExtentReportManager.info("Step 3: Click Eye Password again to hide password");
        LOG.info("Step 3: Click Eye Password again to hide password");
        registerPage.clickEyePassword();

        String fieldTypeAfterSecondClick = registerPage.getPasswordFieldType();
        ExtentReportManager.info("Verify Point 3: Password field type is 'password' after clicking eye icon again");
        LOG.info("Verify Point 3: Password field type is 'password' after clicking eye icon again");
        Assert.assertEquals(fieldTypeAfterSecondClick, "password");

    }

}

package registertestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC14_VerifyDifferentPassMsg extends BaseTestPage {
    @Test(description = "RegisterPage Test 14 - Validate error message when password and confirm password are different")
    public void testValidatePasswordAndConfirmPasswordMismatch() {
        pages.RegisterPage registerPage = new pages.RegisterPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        homePage.getTopBarNavigation().navigateRegisterPage();

        ExtentReportManager.info("Step 1: Enter password");
        LOG.info("Step 3: Enter password");
        registerPage.enterPass("Test123456@");

        ExtentReportManager.info("Step 2: Enter confirm password");
        LOG.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPass("Test123456");
        registerPage.clickRegister();

        String actualErrorMessage = registerPage.getFieldConfirmPassError();
        Assert.assertEquals(actualErrorMessage, "Mật khẩu không khớp !");
    }
}

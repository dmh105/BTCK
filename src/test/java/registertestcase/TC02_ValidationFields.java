package registertestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import pages.RegisterPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC02_ValidationFields extends BaseTestPage {
    @Test(description = "RegisterPage Test 02 - Validate Required Fields")
    public void testCase2() {
        RegisterPage registerPage = new RegisterPage();
        HomePage homePage = new HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");

        ExtentReportManager.info("Step 1: click account field and leave it blank");
        LOG.info("Step click account field and leave it blank");
        registerPage.clickAccountField();

        ExtentReportManager.info("Step 2: click password field and leave it blank");
        LOG.info("Step click password field and leave it blank");
        registerPage.clickPasswordField();

        ExtentReportManager.info("Step 3: click confirm password field and leave it blank");
        LOG.info("Step click confirm password field and leave it blank");
        registerPage.clickConfirmPasswordField();

        ExtentReportManager.info("Step 4: click name field and leave it blank");
        LOG.info("Step click name field and leave it blank");
        registerPage.clickNameField();

        ExtentReportManager.info("Step 5: click email field and leave it blank");
        LOG.info("Step click email field and leave it blank");
        registerPage.clickEmailField();
        registerPage.clickRegister();

        String actualNameError = registerPage.getFieldNameError();
        String actualEmailError = registerPage.getFieldEmailError();
        String actualAccError = registerPage.getFieldAccError();
        String actualPassError = registerPage.getFieldPassError();
        String actualConfirmPassError = registerPage.getFieldConfirmPassError();

        Assert.assertEquals(actualNameError, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualEmailError, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualAccError, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualPassError, "Đây là trường bắt buộc !");
        Assert.assertEquals(actualConfirmPassError, "Đây là trường bắt buộc !");
    }
}

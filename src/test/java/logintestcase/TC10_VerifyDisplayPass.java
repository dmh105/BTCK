package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC10_VerifyDisplayPass extends BaseTestPage {
    @Test(description = "Login Test 10 - Eye Password Functionality")
    public void testLogin10() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");
        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step1: nhập password");
        LOG.info("Step1: nhập password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 2: Click Eye Password");
        LOG.info("Step 2: Click Eye Password");
        String fieldType = loginPage.getPasswordFieldType();
        ExtentReportManager.info("VP1: Password field type is 'password'");
        LOG.info("VP1: Password field type is 'password'");
        Assert.assertEquals(fieldType, "password");

        loginPage.clickEyePassword();
        String fieldTypeAfterClick = loginPage.getPasswordFieldType();
        Assert.assertEquals(fieldTypeAfterClick, "text");

    }
}

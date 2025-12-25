package registertestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

import java.util.UUID;

@Listeners(TestListeners.class)
public class TC11_VerifyExistEmail extends BaseTestPage {
    @Test(description = "RegisterPage Test 11 - Email exist validation")
    public void testValidateEmailField() {
        pages.RegisterPage registerPage = new pages.RegisterPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        homePage.getTopBarNavigation().navigateRegisterPage();

        ExtentReportManager.info("Step 1: Enter account");
        LOG.info("Step 2: Enter account");
        String account = UUID.randomUUID().toString();
        registerPage.enterAcc(account);

        ExtentReportManager.info("Step 2: Enter password");
        LOG.info("Step 3: Enter password");
        registerPage.enterPass("Test123456@");

        ExtentReportManager.info("Step 3: Enter confirm password");
        LOG.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPass("Test123456@");

        ExtentReportManager.info("Step 4: Enter name");
        LOG.info("Step 5: Enter name");
        registerPage.enterName("John A");

        ExtentReportManager.info("Step 5: Enter email");
        LOG.info("Step 6: Enter email");
        String email = "ed1700c4-0a40-478f-b710-bb42b0d401d3@example.com";
        registerPage.enterEmail(email);

        ExtentReportManager.info("Step 6: Click register button");
        LOG.info("Step 7: Click register button");
        registerPage.clickRegister();

        ExtentReportManager.info("Verify Point: Error message for existed email format is displayed");
        LOG.info("Verify Point: Error message for existed email format is displayed");
        String errorMessage = registerPage.getEmailExistError();
        Assert.assertEquals(errorMessage, "Email đã tồn tại!");
    }
}

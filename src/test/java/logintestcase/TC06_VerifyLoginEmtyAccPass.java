package logintestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC06_VerifyLoginEmtyAccPass extends BaseTestPage {
    @Test(description = "Login Test 05 - Required Account and Password Fields")
    public void testLogin05() {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        homePage.getTopBarNavigation().navigateLoginPage();
        loginPage.clickLogin();

        String actualRequiredPasswordMsg = loginPage.getRequiredPasswordMsg();
        String actualRequiredAccountMsg = loginPage.getRequiredAccountMsg();

        Assert.assertEquals(actualRequiredPasswordMsg, "Đây là trường bắt buộc !", "Test Passed!");
        Assert.assertEquals(actualRequiredAccountMsg, "Đây là trường bắt buộc !", "Test Passed!");
        ExtentReportManager.pass("PASSED");
    }
}

package bookinghistorytestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC04 extends BaseTestPage {
    @Test(description = "Verify that all information for a ticket booking is displayed")
    public void testCase4() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.ProfilePage profilePage = new pages.ProfilePage();
        driver.get("https://demo1.cybersoft.edu.vn/sign-in");

        ExtentReportManager.info("Step 1: Login");
        LOG.info("Step 1: Login");
        String account = "010101";
        loginPage.enterAccount(account);
        loginPage.enterPassword("Mchose2888@");
        loginPage.clickLogin();
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Navigate to Profile Page");
        LOG.info("Step 2: Navigate to Profile Page");
        loginPage.clickProfile();
        Thread.sleep(5000);

        ExtentReportManager.info("Verify Point 1: Booking history is displayed full information");
        LOG.info("Verify Point 1: Booking history is displayed full information");
        boolean verifyData = profilePage.isDataBookingDisplayed();
        Assert.assertTrue(verifyData, "Test Fail");
    }
}

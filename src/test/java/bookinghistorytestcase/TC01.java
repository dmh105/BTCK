package bookinghistorytestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC01 extends BaseTestPage {
    @Test(description = "Show history of booking on Profile Page")
    public void testCase1() throws InterruptedException {
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

        ExtentReportManager.info("Verify Point 1: Count of booking history is displayed");
        LOG.info("Verify Point 1: Count of booking history is displayed");
        int bookingCount = profilePage.getAllBookingItems();
        System.out.println("Booking Count: " + bookingCount);
        Assert.assertEquals(14, bookingCount, "Booking count does not match expected value.");
    }

}

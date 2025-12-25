package bookinghistorytestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC03 extends BaseTestPage {
    @Test(description = "Verify booking history is displayed in ascending order by booking date on Profile Page")
    public void testCase3() throws InterruptedException {
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

        ExtentReportManager.info("Verify Point 1: Booking history is displayed in ascending order by booking date");
        LOG.info("Verify Point 1: Booking history is displayed in ascending order by booking date");
        boolean isAscending = profilePage.isSortedByDate();
        Assert.assertTrue(isAscending, "Booking history is not sorted in ascending order by booking date.");
    }
}

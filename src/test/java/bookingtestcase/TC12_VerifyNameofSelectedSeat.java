package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.BookingPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC12_VerifyNameofSelectedSeat extends BaseTestPage {
    @Test(description = "Test 12 - Verify display name of selected seat")
    public void testCase12() throws InterruptedException {
        HomePage homePage = new HomePage();
        BookingPage bookingPage = new BookingPage();
        ExtentReportManager.info("Step 1: Navigate to home page");
        LOG.info("Step 1: Navigate to home page");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose Cinema");
        LOG.info("Step 2: Choose Cinema");
        homePage.clickBtnCinemaLogo(0);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 3: Choose Cinema Location and Movie + Time");
        LOG.info("Step 3: Choose Movie and Time");
        homePage.clickShowTime(0, 4, 0);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 4: Choose normal Seat");
        LOG.info("Step 4: Choose Seat");
        String NormalSeat = bookingPage.NormalSeat();

        ExtentReportManager.info("Step 5: Choose vip Seat");
        LOG.info("Step 5: Choose Seat");
        String VipSeat = bookingPage.VipSeat();

        ExtentReportManager.info("VP1: Verify display seat when choose seat");
        LOG.info("VP1: Verify display seat when choose seat");
        String seat = String.format("Ghế %s,Ghế %s,", NormalSeat, VipSeat);
        Assert.assertEquals(bookingPage.getLblSelectedSeat(), seat, "FAIL");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

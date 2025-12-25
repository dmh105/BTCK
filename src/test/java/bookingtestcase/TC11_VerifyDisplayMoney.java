package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.BookingPage;
import pages.HomePage;
import reports.ExtentReportManager;

import java.util.Random;

@Listeners(TestListeners.class)
public class TC11_VerifyDisplayMoney extends BaseTestPage {
    @Test(description = "Test 11 - Verify display money when choose seat")
    public void testCase11() throws InterruptedException {
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
        bookingPage.RandomNormalSeat();

        ExtentReportManager.info("Step 5: Choose vip Seat");
        LOG.info("Step 5: Choose Seat");
        bookingPage.RandomVipSeat();

        ExtentReportManager.info("VP1: Verify display money when choose seat");
        LOG.info("VP1: Verify display money when choose seat");
        String Money = bookingPage.getTotalMoney();
        Assert.assertEquals(Money, "165000VND", "FAIL");

        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

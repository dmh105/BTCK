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
public class TC13_VerifyNotificationDisplay extends BaseTestPage {
    @Test(description = "Test 13 - Verify Login Notification display")
    public void testCase13() throws InterruptedException {
        HomePage homePage = new HomePage();
        BookingPage bookingPage = new BookingPage();
        ExtentReportManager.info("Step 1: Navigate to home page");
        LOG.info("Step 1: Navigate to home page");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose Cinema");
        LOG.info("Step 2: Choose Cinema");
        homePage.clickBtnCinemaLogo(0);
        Thread.sleep(8000);

        ExtentReportManager.info("Step 3: Choose Cinema Location and Movie + Time");
        LOG.info("Step 3: Choose Movie and Time");
        homePage.clickShowTime(0, 4, 0);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 4: Choose normal Seat");
        LOG.info("Step 4: Choose Seat");
        bookingPage.RandomNormalSeat();

        ExtentReportManager.info("Step 5: Click 'Đặt vé' button");
        LOG.info("Step 5: Click 'Đặt vé' button");
        bookingPage.Buy();

        ExtentReportManager.info("VP1: Verify display need to login notification");
        LOG.info("VP1: Verify display need to login notification");
        String actualMsg = bookingPage.getMsg();
        Assert.assertEquals(actualMsg, "Bạn chưa đăng nhập", "FAIL");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }

}

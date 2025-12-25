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
public class TC10_VerifyClickabe extends BaseTestPage {
    @Test(description = "Test 10 - Verify can click on emty seat ")
    public void testCase10() throws InterruptedException {
        HomePage homePage = new HomePage();
        BookingPage bookingPage = new BookingPage();
        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Vào HomePage");
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

        ExtentReportManager.info("VP1: Verify click on emty seat");
        LOG.info("VP1: Verify click on emty seat");
        System.out.println(bookingPage.TotalBtnEnableSeat());
        for (int i = 0; i < bookingPage.TotalBtnEnableSeat(); i++) {
            boolean isClick = bookingPage.isClickSeat(i);
            Assert.assertTrue(isClick, "Fail at " + i);
        }
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

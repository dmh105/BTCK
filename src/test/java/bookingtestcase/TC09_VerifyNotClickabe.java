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
public class TC09_VerifyNotClickabe extends BaseTestPage {
    @Test(description = "Test 9 - Verify cannot click on seat has been booked ")
    public void testCase9() throws InterruptedException {
        HomePage homePage = new HomePage();
        BookingPage bookingPage = new BookingPage();
        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
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


        ExtentReportManager.info("VP1: Verify can not click on booked seat");
        LOG.info("VP1: Verify can not click on booked seat");
        if (bookingPage.TotalDisableBtn() == 0) {
            Assert.assertEquals(bookingPage.TotalDisableBtn(), 0);
            ExtentReportManager.pass("All seat can click");
        } else {
            for (int i = 0; i < bookingPage.TotalDisableBtn(); i++) {
                boolean isCLickDisable = bookingPage.isDisableClickSeat(i);
                Assert.assertFalse(isCLickDisable, "Fail at " + i);
                ExtentReportManager.pass("PASS");
            }
        }
    }
}

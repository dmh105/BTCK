package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.DetailPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC08_VerifyPickTime extends BaseTestPage {
    @Test(description = "Test 8 - Verify choose DateTime in detail Page and navigate to booking page")
    public void testCase8() throws InterruptedException {
        HomePage homePage = new HomePage();
        DetailPage detailPage = new DetailPage();
        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Click buy now button in carousel");
        LOG.info("Step 2: Click buy now button in carousel");
        homePage.clickBtnBuyinCarousel(2);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 3: Choose Cinema");
        LOG.info("Step 3: Choose Cinema");
        detailPage.clickCinemaLogoDetailPage(1);

        ExtentReportManager.info("Step 4: Choose cinema location and time");
        LOG.info("Step 4: Choose cinema location and time");
        detailPage.clickShowTimeByCinemaDetailPage(1, 0);

        ExtentReportManager.info("VP1: Verify Link to Booking Page");
        LOG.info("VP1: Verify Link to Booking Page");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo1.cybersoft.edu.vn/purchase/45055", "FAIL");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

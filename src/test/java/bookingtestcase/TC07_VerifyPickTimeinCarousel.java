package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC07_VerifyPickTimeinCarousel extends BaseTestPage {
    @Test(description = "Test 7 - Verify Link to Booking Page when click a time in carousel 2 ")
    public void testCase7() throws InterruptedException {
        HomePage homePage = new HomePage();
        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose Cinema");
        LOG.info("Step 2: Choose Cinema");
        homePage.clickBtnCinemaLogo(2);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 3: Choose Cinema Location and Movie + Time");
        LOG.info("Step 3: Choose Movie and Time");
        homePage.clickShowTime(1, 0, 0);
        Thread.sleep(5000);

        ExtentReportManager.info("VP1: Verify Link to Booking Page");
        LOG.info("VP1: Verify Link to Booking Page");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo1.cybersoft.edu.vn/purchase/42754", "FAIL");

        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

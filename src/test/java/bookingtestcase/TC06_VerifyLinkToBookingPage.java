package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC06_VerifyLinkToBookingPage extends BaseTestPage {
    @Test(description = "Test 6 - Verify Link to choose DateTime Page when click buy button in carousel ")
    public void testCase6() throws InterruptedException {
        HomePage homePage = new HomePage();
        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Click vào button 'Mua vé'");
        LOG.info("Step 2: Click vào button 'Mua vé'");
        String urlBooking = homePage.getUrlAndClickItem(0);
        Thread.sleep(5000);

        ExtentReportManager.info("VP1: Verify navigate to link booking");
        LOG.info("VP1: Verify navigate to link booking");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, urlBooking, "FAIL");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

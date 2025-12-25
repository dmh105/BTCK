package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC02_VerifyNotification extends BaseTestPage {
    @Test(description = "Test 02 - Verify Notification when not choose movie")
    public void testCase2() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Vào HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Click buy now button");
        LOG.info("Step 2: Click  buy now button");
        homePage.clickBtnBuy();
        String actualMsg = homePage.getMsg();

        ExtentReportManager.info("VP1: 'Chưa chọn phim' message displays");
        LOG.info("VP1: 'Chưa chọn phim' message displays");
        Assert.assertEquals(actualMsg, "Bạn chưa chọn phim");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

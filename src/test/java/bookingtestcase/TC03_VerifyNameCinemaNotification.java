package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC03_VerifyNameCinemaNotification extends BaseTestPage {
    @Test(description = "Test 03 - Verify Notification when not choose cinema")
    public void testCase03() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose a movie");
        LOG.info("Step 2: Choose a movie");
        homePage.selectOptionMovieByIndex(1);
        String actualMovieName = homePage.getMovieName(1);

        ExtentReportManager.info("Step 3: Click buy now button");
        LOG.info("Step 3: Click  buy now button");
        homePage.clickBtnBuy();

        ExtentReportManager.info("VP1: 'Chưa chọn phim' message displays");
        LOG.info("VP1: 'Chưa chọn phim' message displays");
        String actualMsg = homePage.getMsg();
        Assert.assertEquals(actualMovieName, "The Gentlemen");
        Assert.assertEquals(actualMsg, "Bạn chưa chọn rạp");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

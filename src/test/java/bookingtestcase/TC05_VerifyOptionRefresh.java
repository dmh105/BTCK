package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC05_VerifyOptionRefresh extends BaseTestPage {
    @Test(description = "Test 5 - Verify option refresh when choose another moive")
    public void testCase5() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose a movie");
        LOG.info("Step 2: Choose a movie");
        homePage.selectOptionMovieByIndex(1);
        Thread.sleep(3000);

        ExtentReportManager.info("Step 3: Choose a Cinema");
        LOG.info("Step 3: Choose a Cinema");
        homePage.selectOptionCinemaByIndex(1);

        ExtentReportManager.info("Step 4: Choose showtime");
        LOG.info("Step 4: Choose showtime");
        homePage.selectOptionTimeByIndex(1);

        ExtentReportManager.info("Step 5: Choose a movie again");
        LOG.info("Step 2: Choose a movie");
        homePage.selectOptionMovieByIndex(2);
        Thread.sleep(3000);

        ExtentReportManager.info("VP1: Verify option choose cinema and showtime is reset");
        LOG.info("VP1: Verify option choose cinema and showtime is reset");
        boolean isCinemaOptionDefault = homePage.isCinemaOptionDefault();
        boolean isShowtimeOptionDefault = homePage.isShowTimesDefault();
        Assert.assertTrue(isShowtimeOptionDefault, "FAIL at case cinema");
        Assert.assertTrue(isCinemaOptionDefault, "FAIL at case showtime");

        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

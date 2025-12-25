package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC01_VerifyNavigateToBookingPage extends BaseTestPage {
    @Test(description = "Test 01 - Verify Link to Booking Page when choose full option ")
    public void testCase1() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Step 1: Vào HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose a movie");
        LOG.info("Step 2: Choose a movie");
        homePage.selectOptionMovieByIndex(3);
        String actualMovieName = homePage.getMovieName(3);
        Thread.sleep(3000);

        ExtentReportManager.info("Step 3: Choose a Cinema");
        LOG.info("Step 3: Choose a Cinema");
        homePage.selectOptionCinemaByIndex(3);
        String actualCinemaName = homePage.getCinemaName(3);

        ExtentReportManager.info("Step 4: Choose showtime");
        LOG.info("Step 4: Choose showtime");
        homePage.selectOptionTimeByIndex(1);
        String actualShowtime = homePage.getDateTime(1);

        ExtentReportManager.info("Step 5: Click  buy now button");
        LOG.info("Step 5: Click  buy now button");
        homePage.clickBtnBuy();
        String actualURL = driver.getCurrentUrl();

        ExtentReportManager.info("VP1: Navigate to booking of choose item");
        LOG.info("VP1: Navigate to booking of choose item");
        Assert.assertEquals(actualMovieName, "AVATAR 2", "FAIL at movie name");
        Assert.assertEquals(actualCinemaName, "CGV - VivoCity", "FAIL at cinema name");
        Assert.assertEquals(actualShowtime, "07/10/2021 ~ 08:25", "FAIL at cinema name");
        Assert.assertEquals(actualURL, "https://demo1.cybersoft.edu.vn/purchase/45055", "Fail at URL case");
        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

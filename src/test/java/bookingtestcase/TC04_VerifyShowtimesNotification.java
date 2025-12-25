package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC04_VerifyShowtimesNotification extends BaseTestPage {
    @Test(description = "Test 4 - Verify Notification when not choose showtimes")
    public void testCase4() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Navigate to HomePage");
        LOG.info("Navigate to HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("Step 2: Choose a movie");
        LOG.info("Step 2: Choose a movie");
        homePage.selectOptionMovieByIndex(1);
        String actualMovieName = homePage.getMovieName(1);
        Thread.sleep(3000);

        ExtentReportManager.info("Step 3: Choose a Cinema");
        LOG.info("Step 3: Choose a Cinema");
        homePage.selectOptionCinemaByIndex(1);
        String actualCineMaName = homePage.getCinemaName(1);

        ExtentReportManager.info("Step 4: Click  buy now button");
        LOG.info("Step 4: Click  buy now button");
        homePage.clickBtnBuy();

        ExtentReportManager.info("VP1: 'Bạn chưa chọn ngày giờ chiếu' message displays");
        LOG.info("VP1: 'Bạn chưa chọn ngày giờ chiếu' message displays");
        String actualMsg = homePage.getMsg();
        Assert.assertEquals(actualMovieName, "The Gentlemen", "FAIL at movie name");
        Assert.assertEquals(actualCineMaName, "CGV - Golden Plaza", "FAIL at cinema name");
        Assert.assertEquals(actualMsg, "Bạn chưa chọn ngày giờ chiếu", "FAIL at Notification");

        ExtentReportManager.info("PASS");
        LOG.info("PASS");
    }
}

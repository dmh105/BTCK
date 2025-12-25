package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC03_VerifyListMovie extends BaseTestPage {
    @Test(description = "Test 03 - Verify File Name in list")
    public void test05() throws InterruptedException {
        HomePage homePage = new HomePage();
        ExtentReportManager.info("Step 1: Vào HomePage");
        LOG.info("Step 1: Vào HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("VP1: Verify movie option display ");
        LOG.info("VP1: Verify movie option display");
        boolean isMovieOptiondDisplay = homePage.verifySelectAndPrintOptions();
        Assert.assertTrue(isMovieOptiondDisplay, "Fail");
    }
}

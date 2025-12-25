package homepagetestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.HomePage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC01 extends BaseTestPage {
    @Test(description = "Test 01 - Verify Carousel")
    public void testCase1() throws InterruptedException {
        HomePage homePage = new HomePage();

        ExtentReportManager.info("Step 1: Vào HomePage");
        LOG.info("Step 1: Vào HomePage");
        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(5000);

        ExtentReportManager.info("VP1: Carousel btn display ");
        LOG.info("VP1: Carousel btn display");
        int a = homePage.getItemCarousel();
        Assert.assertEquals(8, a, "Fail");
        boolean isDisplayed = homePage.isBtnCarouselDisplay();
        Assert.assertTrue(isDisplayed, "Fail");

        String ItemLink1 = homePage.getHref();

        ExtentReportManager.info("VP2: Check if the CLICK → SLIDE has changed");
        LOG.info("VP2: Check if the CLICK → SLIDE has changed");

        ExtentReportManager.info("Step 2: Click btn right");
        LOG.info("Step 2: Click btn right");
        homePage.ClickBtnRight();
        Thread.sleep(5000);

        String ItemLink2 = homePage.getHref();
        boolean b;
        if (!ItemLink1.equals(ItemLink2)) {
            b = true;
        } else b = false;

        Assert.assertTrue(b, "Fail");
    }
}

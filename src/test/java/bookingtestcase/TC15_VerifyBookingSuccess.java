package bookingtestcase;

import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTestPage;
import pages.BookingPage;
import reports.ExtentReportManager;

@Listeners(TestListeners.class)
public class TC15_VerifyBookingSuccess extends BaseTestPage {
    @Test(description = "Test 15 - Verify Booking Success")
    public void testCase15() throws InterruptedException {
        pages.LoginPage loginPage = new pages.LoginPage();
        pages.HomePage homePage = new pages.HomePage();
        BookingPage bookingPage = new BookingPage();
        driver.get("https://demo1.cybersoft.edu.vn/");
        ExtentReportManager.info("Step 1: click đăng nhập link on top right");
        LOG.info("Step1: click đăng nhập link on top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        ExtentReportManager.info("Step 2: nhập acc");
        LOG.info("Step2: nhập acc");
        String account = "d75fe03d-ef7b-4d9b-b2ec-9fe85f72ac60";
        loginPage.enterAccount(account);

        ExtentReportManager.info("Step 3: nhập password");
        LOG.info("Step 3: nhập password");
        loginPage.enterPassword("Test123456@");

        ExtentReportManager.info("Step 4: Click Login");
        LOG.info("Step 4: Click Login");
        loginPage.clickLogin();

        ExtentReportManager.info("VP1: 'Đăng nhập thành công' message displays");
        LOG.info("VP1: 'Đăng nhập thành công' message displays");
        String actualLoginMsg = loginPage.getLoginMsg();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "FAIL");

        Thread.sleep(8000);
        ExtentReportManager.info("Step 5: Choose Cinema");
        LOG.info("Step 5: Choose Cinema");
        homePage.clickBtnCinemaLogo(5);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 6: Choose Cinema Location and Movie + Time");
        LOG.info("Step 6: Choose Movie and Time");
        homePage.clickShowTime(0, 4, 0);
        Thread.sleep(5000);

        ExtentReportManager.info("Step 7: Choose normal Seat");
        LOG.info("Step 7: Choose Seat");
        bookingPage.RandomNormalSeat();

        ExtentReportManager.info("Step 8: Click 'Đặt vé' button");
        LOG.info("Step 8: Click 'Đặt vé' button");
        bookingPage.Buy();

        ExtentReportManager.info("VP2: Verify booking success");
        LOG.info("VP2: Verify booking success");
        String actualMsg = bookingPage.getMsg();
        Assert.assertEquals(actualMsg, "Đặt vé thành công", "FAIL");

        ExtentReportManager.info("PASS");
        LOG.info("PASS");

    }
}

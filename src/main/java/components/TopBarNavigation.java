package components;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import pages.BasePage;

public class TopBarNavigation extends BasePage {
    private By byBtnRegisterLink = By.xpath("//h3[text()='Đăng Ký']");
    private By byBtnLoginLink = By.xpath("//h3[text()='Đăng Nhập']/parent::a");
    private By byBtnShowtimes = By.xpath("//h4[text()='Lịch Chiếu']");
    private By byBtnCinema = By.xpath("//h4[text()='Cụm Rạp']");
    private By byBtnNew = By.xpath("//h4[text()='Tin Tức']");
    private By byBtnApp = By.xpath("//h4[text()='Ứng Dụng']");

    public void navigateRegisterPage() {
        LOG.info("navigateRegisterPage");
        click(DriverFactory.getDriver(), byBtnRegisterLink);
    }

    public void navigateLoginPage() {
        LOG.info("navigateLoginPage");
        click(DriverFactory.getDriver(), byBtnLoginLink);
    }

    public void navigateShowtimesPart() {
        LOG.info("navigateShowtimesPage");
        click(DriverFactory.getDriver(), byBtnShowtimes);
    }

    public void navigateCinemaPart() {
        LOG.info("navigateCinemaPage");
        click(DriverFactory.getDriver(), byBtnCinema);
    }

    public void navigateNewsPart() {
        LOG.info("navigateNewsPage");
        click(DriverFactory.getDriver(), byBtnNew);
    }

    public void navigateAppPart() {
        LOG.info("navigateAppPage");
        click(DriverFactory.getDriver(), byBtnApp);
    }
}

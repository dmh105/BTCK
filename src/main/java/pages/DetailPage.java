package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DetailPage extends CommonPage {
    private By imgCinemaLogo = By.xpath(".//div[@role='tablist']//button");
    private By lnkShowTime = By.xpath("//div[contains(@class,'MuiGrid-spacing-xs-2')]//div/a");
    private By movieBlock = By.xpath("//div[@role='tabpanel']//div//div[contains(@class,'MuiGrid-spacing-xs-2')]");

    public void clickCinemaLogoDetailPage(int index) {
        List<WebElement> cinemaLogos = DriverFactory.getDriver().findElements(imgCinemaLogo);
        cinemaLogos.get(index).click();
    }

    public void clickShowTimeByCinemaDetailPage(int cinemaIndex, int showTimeIndex) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        List<WebElement> cinemaBlocks = waitForVisibilityOfAllElementsLocated(DriverFactory.getDriver(), movieBlock, 10);
        WebElement selectedCinema = cinemaBlocks.get(cinemaIndex);
        List<WebElement> showTimes = wait.until(driver -> selectedCinema.findElements(lnkShowTime));
        WebElement showTime = showTimes.get(showTimeIndex);
        wait.until(ExpectedConditions.elementToBeClickable(showTime)).click();
    }

}

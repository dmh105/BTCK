package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookingPage extends CommonPage {
    private By byLblMsg = By.id("swal2-title");
    private By BtnX = By.xpath("//button[contains(@class,'Mui-disabled')]");
    private By BtnSeat = By.xpath(".//button[contains(@class,'null')]//span[@class='MuiTouchRipple-root']");
    private By LblMoney = By.xpath("(//p[contains(@class,'MuiTypography-body1')])[4]");
    private By BtnVipSeat = By.xpath("//button[contains(@class,'MuiButtonBase-root') and not (contains(@class,'Mui-disabled')) and not (contains(@class,'null null'))]/span[@class='MuiButton-label']");
    private By BtnNormalSeat = By.xpath("//button[contains(@class,'MuiButtonBase-root') and not (contains(@class,'Mui-disabled')) and (contains(@class,'null null'))]/span[@class='MuiButton-label']");
    private By LblSelectedSeat = By.xpath("//div[7]//h3[2]//span");
    private By BtnBooking = By.xpath("//span[text()='ĐẶT VÉ']");
    private By BtnYes = By.xpath("//button[text()='Đồng ý']");

    public String getMsg() {
        LOG.info("Get Msg Notification");
        return getText(DriverFactory.getDriver(), byLblMsg);
    }

    public boolean isDisableClickSeat(int index) {
        return DriverFactory.getDriver().findElements(BtnX).get(index).isEnabled();
    }

    public boolean isClickSeat(int index) {
        return DriverFactory.getDriver().findElements(BtnSeat).get(index).isEnabled();
    }

    public int TotalDisableBtn() {
        return DriverFactory.getDriver().findElements(BtnX).size() - 3;
    }

    public int TotalBtnEnableSeat() {
        return DriverFactory.getDriver().findElements(BtnSeat).size();
    }

    public int RandomNumber(By locator) {
        List<WebElement> list = DriverFactory.getDriver().findElements(locator);
        return ThreadLocalRandom.current().nextInt(0, list.size());
    }

    public void RandomNormalSeat() {
        List<WebElement> list = DriverFactory.getDriver().findElements(BtnNormalSeat);
        list.get(RandomNumber(BtnNormalSeat)).click();
    }

    public void RandomVipSeat() {
        List<WebElement> list = DriverFactory.getDriver().findElements(BtnVipSeat);
        list.get(RandomNumber(BtnVipSeat)).click();
    }

    public String NormalSeat() {
        int a = RandomNumber(BtnNormalSeat);
        List<WebElement> list = DriverFactory.getDriver().findElements(BtnNormalSeat);
        list.get(a).click();
        return list.get(a).getText();
    }

    public String VipSeat() {
        int a = RandomNumber(BtnVipSeat);
        List<WebElement> list = DriverFactory.getDriver().findElements(BtnVipSeat);
        list.get(a).click();
        return list.get(a).getText();
    }

    public String getTotalMoney() {
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), LblMoney).getText();
    }

    public String getLblSelectedSeat() {
        List<WebElement> list = DriverFactory.getDriver().findElements(LblSelectedSeat);
        String text = "";
        for (WebElement a : list) {
            text = text + a.getText();
        }
        return text;
    }

    public void Buy() {
        click(DriverFactory.getDriver(), BtnBooking);
    }

    public void ClickBtnYes() {
        click(DriverFactory.getDriver(), BtnYes);
    }
}

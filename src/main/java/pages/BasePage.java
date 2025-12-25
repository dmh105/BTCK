package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import constant.TimesOut;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasePage {
    protected final Logger LOG = LogManager.getLogger(getClass());

    public WebDriverWait getWait(WebDriver driver, long timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("waitForVisibilityOfElementLocated: %s in %ds", locator, timeOut));
        return getWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(WebDriver driver, By locator) {
        return waitForVisibilityOfElementLocated(driver, locator, TimesOut.DEFAULT_TIMEOUT);
    }

    public List<WebElement> scrollAndCollectBookings(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> result = new ArrayList<>();
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        while (true) {
            List<WebElement> current = driver.findElements(locator);
            // Nếu chưa tìm thấy gì ngay từ lần đầu → lịch sử trống
            if (result.isEmpty() && current.isEmpty()) {
                System.out.println("Không tìm thấy booking nào → Lịch sử đặt vé trống!");
                return result; // trả về list rỗng
            }
            // Thêm item mới vào list kết quả
            for (WebElement item : current) {
                if (!result.contains(item)) {
                    result.add(item);
                }
            }
            // Scroll xuống cuối trang
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(700);
            } catch (InterruptedException ignored) {
            }
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            // Nếu không tăng chiều cao → hết booking để load
            if (newHeight == lastHeight) break;
            lastHeight = newHeight;
        }
        // Nếu scroll hết mà vẫn không tìm thấy booking
        if (result.isEmpty()) {
            System.out.println("Scroll hết trang nhưng không tìm thấy item → Lịch sử trống.");
        }
        return result;
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocated(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("waitForVisibilityOfAllElementsLocated: %s in %ds", locator, timeOut));
        return getWait(driver, timeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("waitForElementToBeClickable: %s in %ds", locator, timeOut));
        return getWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, TimesOut.DEFAULT_TIMEOUT);
    }

    public void waitForInvisibilityOfElementLocated(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("waitForInvisibilityOfElementLocated: %s in %ds", locator, timeOut));
        getWait(driver, timeOut).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOfElementLocated(WebDriver driver, By locator) {
        waitForInvisibilityOfElementLocated(driver, locator, TimesOut.DEFAULT_TIMEOUT);
    }

    public void sendKeys(WebDriver driver, By locator, String value, long timeOut) {
        LOG.info(String.format("sendKeys: %s with %s in %ds", locator, value, timeOut));
        WebElement element = waitForVisibilityOfElementLocated(driver, locator, timeOut);
        element.sendKeys(value);
    }

    public void sendKeys(WebDriver driver, By locator, String value) {
        sendKeys(driver, locator, value, TimesOut.DEFAULT_TIMEOUT);
    }

    public void click(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("click: %s in %ds", locator, timeOut));
        WebElement element = waitForElementToBeClickable(driver, locator, timeOut);
        element.click();
    }

    public void click(WebDriver driver, By locator) {
        click(driver, locator, TimesOut.DEFAULT_TIMEOUT);
    }

    public String getText(WebDriver driver, By locator, long timeOut) {
        LOG.info(String.format("getText: %s in %ds", locator, timeOut));
        WebElement element = waitForVisibilityOfElementLocated(driver, locator, timeOut);
        return element.getText();
    }

    public String getText(WebDriver driver, By locator) {
        return getText(driver, locator, TimesOut.DEFAULT_TIMEOUT);
    }

    public void pressEnter(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public boolean isOptionDefault(WebDriver driver, By locator, String option1) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        if (select.getFirstSelectedOption().getText().equals(option1))
            return true;
        return false;
    }
}

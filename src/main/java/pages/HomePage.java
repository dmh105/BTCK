package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage extends CommonPage {
    private By byCarouselItem = By.xpath("//div[contains(@class,'MuiGrid-spacing-xs-3')]//div[contains(@class,'MuiGrid-grid-xs-12') and contains(@class,'jss192')]");
    private By bybtnCarouselLeft = By.xpath("(//div[contains(@class,'MuiContainer-maxWidthLg')]//div[@class='jss89 ']//button[contains(@class,'MuiIconButton-sizeSmall')])[1]");
    private By bybtnCarouselRight = By.xpath("(//div[contains(@class,'MuiContainer-maxWidthLg')]//div[@class='jss89 ']//button[contains(@class,'MuiIconButton-sizeSmall')])[2]");
    private By bylnkItem = By.xpath("//div[@class='CarouselItem']//div[contains(@class,'MuiContainer-maxWidthMd')]/div//a[text()='MUA VÉ']");
    private By byImgItem = By.xpath("//div[contains(@style, 'background-image: url')]");
    private By byTxtListMovieName = By.name("film");
    private By byBtnBuy = By.xpath("//button//span[text()='MUA VÉ NGAY']");
    private By byLblMsg = By.id("swal2-title");
    private By byTxtCinema = By.name("cinema");
    private By byTxtDateTime = By.name("date");
    private By byLnkDateTime = By.xpath(".//a[contains(@href,'/purchase/')]");
    private By TxtMovieName = By.xpath(".//h2[contains(@class,'MuiTypography-h2')]");
    private By byBtnCinemaLogo = By.xpath("//div[@role='tablist']/button/span/div/img");
    private By byBtnCinema = By.xpath("//div[@role='tabpanel']//div[@role='tablist']//button");
    private By byTxtCinemaBlock = By.cssSelector("div.MuiGrid-container.MuiGrid-spacing-xs-2");
    private By byLnkDateTimeinDetailPage = By.xpath(".//a[contains(@href,'/purchase')]");

    private By TabPanelMovie = By.xpath("//div[@role='tabpanel' and @id='vertical-tabpanel-0'][2]");

    public int getItemCarousel() {
        List<WebElement> list = DriverFactory.getDriver().findElements(byCarouselItem);
        if (list.size() == 0) {
            System.out.println("No item in Carousel");
        }
        return list.size();
    }

    public void ClickBtnLeft() {
        LOG.info("Click BtnLeft");
        waitForElementToBeClickable(DriverFactory.getDriver(), bybtnCarouselLeft).click();
    }

    public void ClickBtnRight() {
        LOG.info("Click BtnLeft");
        waitForElementToBeClickable(DriverFactory.getDriver(), bybtnCarouselRight).click();
    }

    public boolean isBtnCarouselDisplay() {
        List<WebElement> list = DriverFactory.getDriver().findElements(By.xpath("//div[contains(@class,'MuiContainer-maxWidthLg')]//div[@class='jss89 ']//button[contains(@class,'MuiIconButton-sizeSmall')]"));
        for (WebElement a : list) {
            if (!a.isDisplayed()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public String getHref() {
        List<WebElement> list = DriverFactory.getDriver().findElements(bylnkItem);
        System.out.println(list.get(0).getAttribute("href"));
        return list.get(0).getAttribute("href");
    }

    public String getFirstBackgroundImageUrl(WebElement element) {
        String bgImage = element.getCssValue("background-image");
        Pattern pattern = Pattern.compile("url\\([\"']?(.*?)[\"']?\\)");
        Matcher matcher = pattern.matcher(bgImage);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public boolean verifySelectAndPrintOptions() {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtListMovieName);
        Select select = new Select(selectEl);
        List<WebElement> options = select.getOptions();
        if (options.isEmpty()) {
            System.out.println("Select không có option nào");
            return false;
        }

        System.out.println("Select có " + options.size() + " option:");
        for (WebElement option : options) {
            System.out.println(" - " + option.getText());
        }
        return true;
    }

    public void selectOptionMovieByIndex(int index) {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtListMovieName);
        Select select = new Select(selectEl);
        select.selectByIndex(index);
    }

    public String getUrlAndClickItem(int index) {
        Actions actions = new Actions(DriverFactory.getDriver());
        List<WebElement> items = DriverFactory.getDriver().findElements(bylnkItem);
        WebElement buyBtn = items.get(index);
        actions.moveToElement(buyBtn).perform();
        String itemUrl = buyBtn.getAttribute("href");
        buyBtn.click();
        return itemUrl;
    }

    public void clickBtnBuyinCarousel(int index) {
        Actions actions = new Actions(DriverFactory.getDriver());
        List<WebElement> items = DriverFactory.getDriver().findElements(bylnkItem);
        WebElement buyBtn = items.get(index);
        actions.moveToElement(buyBtn).perform();
        buyBtn.click();
    }

    public void clickBtnBuy() {
        LOG.info("click Bye button");
        click(DriverFactory.getDriver(), byBtnBuy);
    }

    public String getMsg() {
        LOG.info("Get Msg Notification");
        return getText(DriverFactory.getDriver(), byLblMsg);
    }

    public void selectOptionCinemaByIndex(int index) {
        LOG.info("Select option " + index);
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtCinema);
        Select select = new Select(selectEl);
        select.selectByIndex(index);
    }

    public String getCinemaName(int index) {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtCinema);
        Select select = new Select(selectEl);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedText = selectedOption.getText().trim();
        return selectedText;
    }

    public String getMovieName(int index) {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtListMovieName);
        Select select = new Select(selectEl);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedText = selectedOption.getText().trim();
        return selectedText;
    }

    public void selectOptionTimeByIndex(int index) {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtDateTime);
        Select select = new Select(selectEl);
        select.selectByIndex(index);
    }

    public String getDateTime(int index) {
        WebElement selectEl = DriverFactory.getDriver().findElement(byTxtDateTime);
        Select select = new Select(selectEl);
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedText = selectedOption.getText().trim();
        return selectedText;
    }

    public boolean isCinemaOptionDefault() {
        if (isOptionDefault(DriverFactory.getDriver(), byTxtCinema, "Rạp"))
            return true;
        return false;
    }

    public boolean isShowTimesDefault() {
        if (isOptionDefault(DriverFactory.getDriver(), byTxtDateTime, "Ngày giờ chiếu"))
            return true;
        return false;
    }

    public void clickBtnCinemaLogo(int index) {
        List<WebElement> list = DriverFactory.getDriver().findElements(byBtnCinemaLogo);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", waitForVisibilityOfElementLocated(DriverFactory.getDriver(), TabPanelMovie));
        if (!list.isEmpty()) {
            WebElement element = list.get(index);
            Actions actions = new Actions(DriverFactory.getDriver());
            actions.moveToElement(element).pause(Duration.ofMillis(300)).click().build().perform();
        } else {
            System.out.println("No cinema to choose");
        }
    }

    public void clickShowTime(int index, int movieIndex, int timeIndex) {
        List<WebElement> list = DriverFactory.getDriver().findElements(byBtnCinema);
        list.get(index).click();
        By byMovieBlock = By.xpath("//div[@role='tabpanel' and @id='vertical-tabpanel-" + index + "']/div/div/div");
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        List<WebElement> movieBlocks = DriverFactory.getDriver().findElements(byMovieBlock);

        WebElement movieBlock = movieBlocks.get(movieIndex);
        String movieName = movieBlock.findElement(TxtMovieName).getText().trim();
        LOG.info("Chọn phim: " + movieName);

        List<WebElement> showTimes = movieBlock.findElements(byLnkDateTime);
        WebElement targetShowTime = showTimes.get(timeIndex);

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", targetShowTime);
        String timeText = targetShowTime.getText().trim();
        LOG.info("Suất chiếu được click: " + timeText);
        targetShowTime.click();
    }

    public void clickShowTimeByCinema(int cinemaIndex, int showTimeIndex) {
        List<WebElement> cinemaBlocks = DriverFactory.getDriver().findElements(byTxtCinemaBlock);

        if (cinemaIndex >= cinemaBlocks.size()) {
            throw new RuntimeException("Cinema index không hợp lệ");
        }
        WebElement cinemaBlock = cinemaBlocks.get(cinemaIndex);
        List<WebElement> showTimes = cinemaBlock.findElements(byLnkDateTimeinDetailPage);

        if (showTimes.isEmpty()) {
            System.out.println("Cinema này không có suất chiếu");
        }

        if (showTimeIndex >= showTimes.size()) {
            System.out.println("Showtime index vượt quá số lượng");
        }

        showTimes.get(showTimeIndex).click();
    }


}


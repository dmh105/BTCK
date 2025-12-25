package pages;

import drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProfilePage extends BasePage {
    private By byTxtAccName = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtEmail = By.id("email");
    private By byTxtFullName = By.id("hoTen");
    private By byTxtPhoneNumber = By.xpath("//input[@name='soDt']");
    private By byBtnEyePassword = By.xpath("//button//span[@class='MuiIconButton-label']");
    private By byBtnUpdate = By.xpath("//button//span[text()='Cập Nhật']");
    private By byLblUpdateMsg = By.xpath("//h2[@class='swal2-title']");
    private By byLblEmailValidationMessage = By.id("email-helper-text");
    private By byLblFullNameValidationMessage = By.id("hoTen-helper-text");
    private By byLblPasswordValidationMessage = By.id("matKhau-helper-text");
    private By byLblPhoneNumberValidationMessage = By.id("soDt-helper-text");
    private By bySelRole = By.id("outlined-age-native-simple");
    private By byCountHistoryBooking = By.xpath("//div[contains(@class,'MuiGrid-grid-xs-12') and contains(@class,'MuiGrid-grid-md-6')]//div[contains(@class,'MuiGrid-container')]");
    private By byTxtDateBooking = By.xpath(".//*[contains(text(),'Ngày đặt')]");
    private By byTxtMovieName = By.xpath(".//*[contains(text(),'Tên phim: ')]");
    private By byTxtDuration = By.xpath(".//*[contains(text(),'Thời lượng: ')]");
    private By byTxtCinema = By.cssSelector("h1.MuiTypography-root.MuiTypography-h1.MuiTypography-colorSecondary");
    private By byTxtCinemaNumber = By.xpath(".//h3[contains(text(),'Rạp')]");
    private By byTxtChairNumber = By.xpath(".//h3[contains(text(),'Ghế số:')]");
    private By byTxtTotal = By.xpath(".//h3[contains(text(),'Giá vé:')]");
    private By BtnCloseUpdateMsg = By.xpath("//button[text()='Đóng']");

    public void clearPassword() {
        LOG.info("Clear Password");
        WebElement passwordField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPassword);
        passwordField.sendKeys(Keys.CONTROL + "a");
        passwordField.sendKeys(Keys.DELETE);
    }

    public void clearEmail() {
        LOG.info("Clear Email");
        WebElement emailField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtEmail);
        emailField.sendKeys(Keys.CONTROL + "a");
        emailField.sendKeys(Keys.DELETE);
    }

    public void clearFullName() {
        LOG.info("Clear Full Name");
        WebElement fullNameField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtFullName);
        fullNameField.sendKeys(Keys.CONTROL + "a");
        fullNameField.sendKeys(Keys.DELETE);
    }

    public void clearPhoneNumber() {
        LOG.info("Clear Phone Number");
        WebElement phoneNumberField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPhoneNumber);
        phoneNumberField.sendKeys(Keys.CONTROL + "a");
        phoneNumberField.sendKeys(Keys.DELETE);
    }

    public void enterAccName(String accName) {
        LOG.info(String.format("Acc Name : %s", accName));
        sendKeys(DriverFactory.getDriver(), byTxtAccName, accName);
    }

    public void enterPassword(String password) {
        LOG.info(String.format("Password : %s", password));
        sendKeys(DriverFactory.getDriver(), byTxtPassword, password);
    }

    public void enterEmail(String email) {
        LOG.info(String.format("Email : %s", email));
        sendKeys(DriverFactory.getDriver(), byTxtEmail, email);
    }

    public void enterFullName(String fullName) {
        LOG.info(String.format("Full Name : %s", fullName));
        sendKeys(DriverFactory.getDriver(), byTxtFullName, fullName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        LOG.info(String.format("Phone Number : %s", phoneNumber));
        sendKeys(DriverFactory.getDriver(), byTxtPhoneNumber, phoneNumber);
    }

    public String getAccName() {
        LOG.info("Get Account Name");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtAccName).getAttribute("value");
    }

    public String getFullName() {
        LOG.info("Get Full Name");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtFullName).getAttribute("value");
    }

    public String getEmail() {
        LOG.info("Get Email");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtEmail).getAttribute("value");
    }

    public String getPhoneNumber() {
        LOG.info("Get Phone Number");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPhoneNumber).getAttribute("value");
    }

    public String getPassword() {
        LOG.info("Get Password");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPassword).getAttribute("value");
    }

    public void clickPhoneNumber() {
        LOG.info("Click Phone Number");
        waitForElementToBeClickable(DriverFactory.getDriver(), byTxtPhoneNumber).click();
    }

    public void clickEyePassword() {
        LOG.info("Click Eye Password");
        waitForElementToBeClickable(DriverFactory.getDriver(), byBtnEyePassword).click();
    }

    public void clickFullName() {
        LOG.info("Click Full Name");
        waitForElementToBeClickable(DriverFactory.getDriver(), byTxtFullName).click();
    }

    public void clickEmail() {
        LOG.info("Click Email");
        waitForElementToBeClickable(DriverFactory.getDriver(), byTxtEmail).click();
    }

    public void clickPassword() {
        LOG.info("Click Password");
        waitForElementToBeClickable(DriverFactory.getDriver(), byTxtPassword).click();
    }

    public void clickUpdate() {
        LOG.info("Click Update Button");
        waitForElementToBeClickable(DriverFactory.getDriver(), byBtnUpdate).click();
    }

    public String getUpdateMessage() {
        LOG.info("Get Update Message");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byLblUpdateMsg).getText();
    }

    public String getEmailValidationMessage() {
        LOG.info("Get Email Validation Message");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byLblEmailValidationMessage).getText();
    }

    public String getFullNameValidationMessage() {
        LOG.info("Get Full Name Validation Message");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byLblFullNameValidationMessage).getText();
    }

    public String getPasswordValidationMessage() {
        LOG.info("Get Password Validation Message");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byLblPasswordValidationMessage).getText();
    }

    public String getPhoneNumberValidationMessage() {
        LOG.info("Get Phone Number Validation Message");
        return waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byLblPhoneNumberValidationMessage).getText();
    }

    public void sendEmojiToFullName(WebDriver driver, String emojiHex) {
        LOG.info(String.format("Send Emoji to Full Name: %s", emojiHex));
        WebElement fullNameField = waitForVisibilityOfElementLocated(driver, byTxtFullName);
        int codePoint = Integer.parseInt(emojiHex, 16);
        String emoji = new String(Character.toChars(codePoint));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", fullNameField, emoji);
    }

    public String getRoleSelectedOption() {
        LOG.info("Get Role Selected Option");
        WebElement roleSelect = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), bySelRole);
        Select select = new Select(roleSelect);
        return select.getFirstSelectedOption().getText();
    }

    public String getPasswordFieldType() {
        LOG.info("Get Password Field Type");
        WebElement passwordField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPassword);
        return passwordField.getAttribute("type");
    }

    public void selectRoleByIndex(int index) {
        LOG.info(String.format("Select Role by Index: %d", index));
        WebElement roleSelect = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), bySelRole);
        Select select = new Select(roleSelect);
        select.selectByIndex(index);
    }

    public boolean checkDropdownRoleIsDisabled() {
        LOG.info("Check if Role Dropdown is Disabled");
        WebElement roleSelect = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), bySelRole);
        return !roleSelect.isEnabled();
    }

    public int getAllBookingItems() {
        List<WebElement> allBookings = scrollAndCollectBookings(DriverFactory.getDriver(), byCountHistoryBooking);
        return allBookings.size();
    }

    public boolean isSortedByDate() {
        List<WebElement> bookings = scrollAndCollectBookings(DriverFactory.getDriver(), byCountHistoryBooking);
        if (bookings.isEmpty()) {
            System.out.println("Lịch sử trống!");
            return true;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        List<LocalDateTime> dates = new ArrayList<>();
        for (WebElement booking : bookings) {
            List<WebElement> candidates = booking.findElements(byTxtDateBooking);
            String candidateText = null;
            //  Chọn phần text phù hợp: ưu tiên element con có cả '|'
            for (WebElement c : candidates) {
                String t = c.getText();
                if (!t.trim().isEmpty() && t.contains("|")) {
                    candidateText = t.trim();
                    break;
                }
            }

            // Nếu không tìm được element con phù hợp thì dùng toàn bộ text của booking
            if (candidateText == null) {
                String full = booking.getText();
                candidateText = full.trim();
            }

            // Trích phần sau ":" và tách theo '|'
            LocalDateTime parsed = null;
            try {
                if (candidateText.contains(":") && candidateText.contains("|")) {
                    // Lấy phần sau dấu ':' đầu tiên
                    String afterColon = candidateText.substring(candidateText.indexOf(":") + 1).trim();
                    // Tách an toàn theo '|', loại bỏ khoảng trắng xung quanh
                    String[] parts = afterColon.split("\\s*\\|\\s*");
                    if (parts.length >= 2) {
                        String datePart = parts[0].trim();
                        String timePart = parts[1].trim();
                        parsed = LocalDateTime.parse(datePart + " " + timePart, formatter);
                    } else {
                        System.out.println("Không tìm thấy phần time sau '|' trong: " + afterColon);
                    }
                } else {
                    System.out.println(" Text không có định dạng '...: dd-MM-yyyy | HH:mm': " + candidateText);
                }
            } catch (Exception ex) {
                System.out.println(" Không parse được: " + candidateText + "  -> " + ex.getMessage());
            }

            if (parsed != null) {
                dates.add(parsed);
                System.out.println("Parsed date: " + parsed.format(formatter));
            } else {
                System.out.println("Bỏ qua booking vì không lấy được ngày hợp lệ.");
            }
        }

        if (dates.size() <= 1) {
            System.out.println("Có ≤ 1 ngày hợp lệ → Không cần kiểm tra sắp xếp.");
            return true;
        }

        // Kiểm tra thứ tự CŨ → MỚI
        for (int i = 1; i < dates.size(); i++) {
            if (dates.get(i).isBefore(dates.get(i - 1))) {
                System.out.println(" Sai thứ tự tại vị trí " + i);
                System.out.println("   " + dates.get(i - 1).format(formatter) + "  ->  " + dates.get(i).format(formatter));
                return false;
            }
        }

        System.out.println("✔ Booking được sắp xếp đúng theo thứ tự CŨ → MỚI");
        return true;
    }

    public String getSafeText(WebElement parent, By locator) {
        List<WebElement> els = parent.findElements(locator);
        if (els.isEmpty()) {
            return "(Không có dữ liệu)";
        }
        StringBuilder sb = new StringBuilder();
        for (WebElement el : els) {
            String text = el.getText().trim();
            if (!text.isEmpty()) {
                sb.append(text).append(" | ");
            }
        }

        return sb.substring(0, sb.length() - 3);
    }

    public String getTextByLocator(WebElement booking, By locator) {
        List<WebElement> els = booking.findElements(locator);
        return els.isEmpty() ? "No data" : els.get(0).getText();
    }

    public void getInformation() {
        List<WebElement> list = scrollAndCollectBookings(DriverFactory.getDriver(), byCountHistoryBooking);
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy booking nào!");
            return;
        }
        int index = 1;
        for (WebElement a : list) {
            System.out.println("========= BOOKING #" + index + " =========");
            String date = getSafeText(a, byTxtDateBooking);
            String movie = getSafeText(a, byTxtMovieName);
            String duration = getSafeText(a, byTxtDuration);
            String cinema = getSafeText(a, byTxtCinema);
            String total = getTextByLocator(a, byTxtTotal);
            String cinemaNumber = getTextByLocator(a, byTxtCinemaNumber);
            String chairNumber = getTextByLocator(a, byTxtChairNumber);

            System.out.println(date);
            System.out.println(movie);
            System.out.println(duration);
            System.out.println(total);
            System.out.println(cinema);
            System.out.println(cinemaNumber);
            System.out.println(chairNumber);
            index++;
        }
    } //in booking ra console de check

    public boolean isDataBookingDisplayed() {
        List<WebElement> bookings =
                scrollAndCollectBookings(DriverFactory.getDriver(), byCountHistoryBooking);
        if (bookings.isEmpty()) {
            System.out.println("Lịch sử đặt vé trống!");
            LOG.info("Lịch sử đặt vé trống!");
            return true;
        }
        int index = 1;
        for (WebElement booking : bookings) {
            String date = getSafeText(booking, byTxtDateBooking);
            String cinemaNumber = getTextByLocator(booking, byTxtCinemaNumber);
            String chairs = getTextByLocator(booking, byTxtChairNumber);
            String total = getTextByLocator(booking, byTxtTotal);
            String movie = getSafeText(booking, byTxtMovieName);
            String duration = getSafeText(booking, byTxtDuration);
            String cinema = getSafeText(booking, byTxtCinema);

            if (date.isEmpty()) {
                System.out.println("Booking #" + index + " thiếu ngày đặt");
                return false;
            }

            if (movie.isEmpty()) {
                System.out.println("Booking #" + index + " thiếu tên phim");
                return false;
            }

            if (duration.isEmpty()) {
                System.out.println("Booking #" + index + " thiếu thời lượng");
                return false;
            }

            if (cinema.isEmpty()) {
                System.out.println("Booking #" + index + " thiếu tên rạp");
                return false;
            }

            if (!total.matches("Giá vé:\\s*\\d+\\sVND")) {
                System.out.println("Booking #" + index + " giá vé sai format: " + total);
                return false;
            }

            if (!cinemaNumber.matches("Rạp\\s+\\d+")) {
                System.out.println("Booking #" + index + " rạp sai format: " + cinemaNumber);
                return false;
            }

            if (!chairs.matches("Ghế số:\\d+( \\d+)*")) {
                System.out.println("Booking #" + index + " ghế sai format: " + chairs);
                return false;
            }

            String[] seatArr = chairs.split(",\\s*");
            Set<String> uniqueSeats = new HashSet<>(Arrays.asList(seatArr));
            if (uniqueSeats.size() != seatArr.length) {
                System.out.println("Booking #" + index + " có ghế trùng: " + chairs);
                return false;
            }

            index++;
        }
        return true;
    }

    public void closeBtnCloseUpdateMsg() {
        LOG.info("Close Update Message Dialog");
        waitForElementToBeClickable(DriverFactory.getDriver(), BtnCloseUpdateMsg).click();
    }
}
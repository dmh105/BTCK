package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends CommonPage {
    private By byTxtAccountLogin = By.id("taiKhoan");
    private By byTxtPasswordLogin = By.id("matKhau");
    private By byBtnLoginForm = By.xpath("//button[.='Đăng nhập']");
    private By byLblLoginMsg = By.id("swal2-title");
    private By byBtnEyePassword = By.xpath("//button//span[@class='MuiIconButton-label']");
    private By byChkRememberMe = By.xpath("(//span[@class='MuiIconButton-label'])[2]");
    private By byTxtRequiredAccount = By.id("taiKhoan-helper-text");
    private By byTxtRequiredPassword = By.id("matKhau-helper-text");
    private By byLblErrorLoginMsg = By.xpath("//div[@class='MuiAlert-message']");
    private By byBtnSignOut = By.xpath("//h3[text()='Đăng xuất']");
    private By TxtLogoutMsg1 = By.xpath("//h2[text()='Bạn có muốn đăng xuất ?']");
    private By ByBtnConfirmLogout = By.xpath("//button[text()='Đồng ý']");
    private By ByTxtLogoutMsg2 = By.id("swal2-title");
    private By byBtnProfile = By.xpath("//a//h3[@class='MuiTypography-root jss13 MuiTypography-h3']");
    private By ByTxtRegisterLink = By.xpath("//h3[text()='Bạn chưa có tài khoản? Đăng ký']");

    public void enterAccount(String account) {
        LOG.info(String.format("enter Account: %s", account));
        sendKeys(DriverFactory.getDriver(), byTxtAccountLogin, account);
    }

    public void enterPassword(String password) {
        LOG.info(String.format("enter Password: %s", password));
        sendKeys(DriverFactory.getDriver(), byTxtPasswordLogin, password);
    }

    public String getPasswordFieldType() {
        LOG.info("get Password Field Type");
        WebElement EyePassword = waitForElementToBeClickable(DriverFactory.getDriver(), byTxtPasswordLogin);
        String type = EyePassword.getAttribute("type");
        return type;
    }

    public void clickEyePassword() {
        LOG.info("click Eye Password");
        click(DriverFactory.getDriver(), byBtnEyePassword);
    }

    public void clickProfile() {
        LOG.info("click Profile");
        click(DriverFactory.getDriver(), byBtnProfile);
    }

    public void clickRememberMe() {
        LOG.info("click Remember Me");
        click(DriverFactory.getDriver(), byChkRememberMe);
    }

    public void clickLogin() {
        LOG.info("click Login");
        click(DriverFactory.getDriver(), byBtnLoginForm);
    }

    public void pressEnterToLogin() {
        LOG.info("press Enter To Login");
        pressEnter(DriverFactory.getDriver());
    }

    public String getLoginMsg() {
        LOG.info("getLoginMsg");
        return getText(DriverFactory.getDriver(), byLblLoginMsg);
    }

    public String getRequiredAccountMsg() {
        LOG.info("getRequiredAccountMsg");
        return getText(DriverFactory.getDriver(), byTxtRequiredAccount);
    }

    public String getRequiredPasswordMsg() {
        LOG.info("getRequiredPasswordMsg");
        return getText(DriverFactory.getDriver(), byTxtRequiredPassword);
    }

    public String getErrorLoginMsg() {
        LOG.info("getErrorLoginMsg");
        return getText(DriverFactory.getDriver(), byLblErrorLoginMsg);
    }

    public void clickSignOut() {
        LOG.info("click Sign Out");
        click(DriverFactory.getDriver(), byBtnSignOut);
    }

    public String getLogoutMsg() {
        LOG.info("getLogoutMsg");
        return getText(DriverFactory.getDriver(), TxtLogoutMsg1);
    }

    public void clickConfirmLogout() {
        LOG.info("click Confirm Logout");
        click(DriverFactory.getDriver(), ByBtnConfirmLogout);
    }

    public String getLogoutSuccessMsg() {
        LOG.info("getLogoutSuccessMsg");
        return getText(DriverFactory.getDriver(), ByTxtLogoutMsg2);
    }

    public String getAccountFieldValue() {
        LOG.info("get Account Field Value");
        WebElement accountField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtAccountLogin);
        return accountField.getAttribute("value");
    }

    public String getPasswordFieldValue() {
        LOG.info("get Password Field Value");
        WebElement passwordField = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPasswordLogin);
        return passwordField.getAttribute("value");
    }

    public void clickRegisterLink() {
        LOG.info("click Register Link");
        click(DriverFactory.getDriver(), ByTxtRegisterLink);
    }


}

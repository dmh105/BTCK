package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends CommonPage {
    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtName = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegisterNewAcc = By.xpath("//button[.='Đăng ký']");
    private By byLblRegisterMsg = By.id("swal2-title");
    private By byLblFieldNameError = By.id("hoTen-helper-text");
    private By byLblFieldEmailError = By.id("email-helper-text");
    private By byLblFieldAccError = By.id("taiKhoan-helper-text");
    private By byLblFieldPassError = By.id("matKhau-helper-text");
    private By byLblFieldConfirmPassError = By.id("confirmPassWord-helper-text");
    private By byBtnEyePassword = By.xpath("(//button//span[@class='MuiIconButton-label'])[1]");
    private By byBtnEyeConfirmPassword = By.xpath("(//button//span[@class='MuiIconButton-label'])[2]");
    private By byLblEmailExistError = By.xpath("//div[@class='MuiAlert-message']");

    public void enterAcc(String acc) {
        LOG.info(String.format("Acc : %s", acc));
        sendKeys(DriverFactory.getDriver(), byTxtAccount, acc);
    }

    public void enterPass(String pass) {
        LOG.info(String.format("Pass : %s", pass));
        sendKeys(DriverFactory.getDriver(), byTxtPassword, pass);
    }

    public void enterConfirmPass(String Confirmpass) {
        LOG.info(String.format("Confirmpass : %s", Confirmpass));
        sendKeys(DriverFactory.getDriver(), byTxtConfirmPassword, Confirmpass);
    }

    public void enterName(String name) {
        LOG.info(String.format("name : %s", name));
        sendKeys(DriverFactory.getDriver(), byTxtName, name);
    }

    public void enterEmail(String email) {
        LOG.info(String.format("email : %s", email));
        sendKeys(DriverFactory.getDriver(), byTxtEmail, email);
    }

    public void clickRegister() {
        LOG.info("clickRegister");
        click(DriverFactory.getDriver(), byBtnRegisterNewAcc);
    }

    public void clickAccountField() {
        LOG.info("clickAccountField");
        click(DriverFactory.getDriver(), byTxtAccount);
    }

    public void clickPasswordField() {
        LOG.info("clickPasswordField");
        click(DriverFactory.getDriver(), byTxtPassword);
    }

    public void clickConfirmPasswordField() {
        LOG.info("clickConfirmPasswordField");
        click(DriverFactory.getDriver(), byTxtConfirmPassword);
    }

    public void clickNameField() {
        LOG.info("clickNameField");
        click(DriverFactory.getDriver(), byTxtName);
    }

    public void clickEmailField() {
        LOG.info("clickEmailField");
        click(DriverFactory.getDriver(), byTxtEmail);
    }

    public String getRegisterMessage() {
        LOG.info("getRegisterMessage");
        return getText(DriverFactory.getDriver(), byLblRegisterMsg);
    }

    public String getFieldNameError() {
        LOG.info("getFieldNameError");
        return getText(DriverFactory.getDriver(), byLblFieldNameError);
    }

    public String getFieldEmailError() {
        LOG.info("getFieldEmailError");
        return getText(DriverFactory.getDriver(), byLblFieldEmailError);
    }

    public String getFieldAccError() {
        LOG.info("getFieldAccError");
        return getText(DriverFactory.getDriver(), byLblFieldAccError);
    }

    public String getFieldPassError() {
        LOG.info("getFieldPassError");
        return getText(DriverFactory.getDriver(), byLblFieldPassError);
    }

    public String getFieldConfirmPassError() {
        LOG.info("getFieldConfirmPassError");
        return getText(DriverFactory.getDriver(), byLblFieldConfirmPassError);
    }

    public void waitRegisterMessageDisappear(WebDriverWait wait) {
        waitForInvisibilityOfElementLocated(DriverFactory.getDriver(), byLblRegisterMsg);
    }

    public void clickEyePassword() {
        LOG.info("clickEyePassword");
        click(DriverFactory.getDriver(), byBtnEyePassword);
    }

    public void clickEyeConfirmPassword() {
        LOG.info("clickEyeConfirmPassword");
        click(DriverFactory.getDriver(), byBtnEyeConfirmPassword);
    }

    public String getPasswordFieldType() {
        LOG.info("getPasswordFieldType");
        WebElement eyePassword = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtPassword);
        return eyePassword.getAttribute("type");
    }

    public String getConfirmPasswordFieldType() {
        LOG.info("getConfirmPasswordFieldType");
        WebElement eyeConfirmPassword = waitForVisibilityOfElementLocated(DriverFactory.getDriver(), byTxtConfirmPassword);
        return eyeConfirmPassword.getAttribute("type");
    }

    public String getEmailExistError() {
        LOG.info("getEmailErrorMessage");
        return getText(DriverFactory.getDriver(), byLblEmailExistError);
    }

    public void saveAccountInfo(String account, String password, String name, String email) {
        String filePath = System.getProperty("user.dir") + "/test_Account/RegisterAccount.txt";

        try {
            new File(filePath).getParentFile().mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String content = String.format(
                        "Thời gian: %s%nUsername: %s%nPassword: %s%nHọ tên: %s%nEmail: %s%n%s%n",
                        timestamp, account, password, name, email, "=".repeat(40)
                );
                writer.write(content);
                System.out.println("✓ Đã lưu: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}



package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        this.driver = new FirefoxDriver();
    }
}

package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-notifications"); //Vô hiệu hóa thông báo trình duyệt.
        options.addArguments("--disable-popup-blocking"); //Vô hiệu hóa chặn popup trình duyệt.
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); //Vô hiệu hóa popup gợi ý lưu mật khẩu.
        prefs.put("profile.password_manager_enabled", false);//Tránh Chrome bật password manager khi test login.
        //prefs.put("profile.default_content_settings.popups", 0); //Chặn popup
        //prefs.put("password_leak_detection_enabled", false); //Tắt cảnh báo rò rỉ mật khẩu
        options.setExperimentalOption("prefs", prefs);
        this.driver = new ChromeDriver(options);

    }

}

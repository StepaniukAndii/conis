package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class ConfigSelenide {


    public static void remoteConfig() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("enableVNC", false);
        hashMap.put("enableVideo", false);

        Configuration.remote = "http://192.168.68.233:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setVersion("108.0");
        capabilities.setCapability("selenoid:options", hashMap);
        Configuration.browserCapabilities = capabilities;
    }
}

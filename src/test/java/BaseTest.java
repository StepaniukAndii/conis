import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.ConfigProfile;
import utils.ConfigSelenide;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite
    public void config() {
        ConfigProfile configProfile = new ConfigProfile();
        Configuration.timeout = 15000;
        Configuration.headless = configProfile.getHeadless();
        Configuration.screenshots = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        if (configProfile.getSelenoid()) {
            ConfigSelenide.remoteConfig();
        } else {
            Configuration.baseUrl = configProfile.getEnv();
        }
    }

    public String getActualUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public String getExpectedUrl(String url) {
        return Configuration.baseUrl + url;
    }
}

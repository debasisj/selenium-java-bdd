package framework.driverhelpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChromeDriverHelper {
    public WebDriver CreateChromeDriver(){
        return setUpChromeDriver("");
    }
    public WebDriver CreateHeadlessChromeDriver(){
        return setUpChromeDriver("headless");
    }

    private WebDriver setUpChromeDriver(String chromeDriverType){
        WebDriverManager.chromedriver().architecture(Architecture.DEFAULT).browserVersion("").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (chromeDriverType.toLowerCase()){
            case "headless" -> chromeOptions.addArguments("start-maximized","--disable-gpu","no-sandbox","--headless=new");
            default -> chromeOptions.addArguments("start-maximized","--disable-gpu","no-sandbox");
        }
        Map<String, Object> prefs = new LinkedHashMap<>();
        prefs.put("credentials_enable_service",Boolean.FALSE);
        prefs.put("profile.password_manager_enabled", Boolean.FALSE);
        chromeOptions.setExperimentalOption("prefs",prefs);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new ChromeDriver(chromeOptions);
    }
}

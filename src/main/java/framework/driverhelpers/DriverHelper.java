package framework.driverhelpers;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverHelper {
    private final ChromeDriverHelper chromeDriverHelper = new ChromeDriverHelper();
    private final EdgeDriverHelper edgeDriverHelper = new EdgeDriverHelper();

    public WebDriver InvokeDriver(TestConstants.BrowserType browserType) {
        try {
            var driver = switch (browserType) {
                case CHROME -> chromeDriverHelper.CreateChromeDriver();
                case CHROME_HEADLESS -> chromeDriverHelper.CreateHeadlessChromeDriver();
                case FIREFOX -> null;
                case EDGE -> null;
            };
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            return driver;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}

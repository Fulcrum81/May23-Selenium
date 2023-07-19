package selenium.tests.page_objects.staticpo;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    private static void initDriver() throws MalformedURLException {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", Browser.CHROME.getBrowserName()));

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setBrowserName(browser.getBrowserName());
        caps.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL("http://192.168.249.1:4444/wd/hub"), caps);

//        switch (browser) {
//            case CHROME -> caps.setBrowserName(CHROME);
//            case EDGE -> caps.setBrowserName(EDGE);
//            case SAFARI -> new SafariDriver();
//        };

        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }



}

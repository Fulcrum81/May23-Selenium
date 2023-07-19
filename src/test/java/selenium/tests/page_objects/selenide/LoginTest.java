package selenium.tests.page_objects.selenide;//package selenium.tests.page_objects.object;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    private static String disabledEmail = "vadim.zubovich@gmail.com";
    private static String correctPassword = "Test1234!";

    private static String incorrectPassword = "akljsdfhsaklhjf";
    private static String url = "https://litecart.stqa.ru/en/";


    @BeforeMethod
    public static void setup() throws MalformedURLException {
        Configuration.baseUrl = url;
        Configuration.pageLoadTimeout = 5000;
        Configuration.browser = "chrome";

        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 13");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-vadim.zubovich-d99af");
        sauceOptions.put("accessKey", "7a914d85-e3d3-4096-97ff-a44833ea27ae");
        sauceOptions.put("build", "new build");
        sauceOptions.put("name", "Login test");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL sauceUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(sauceUrl, browserOptions);
        driver.manage().window().maximize();

        WebDriverRunner.setWebDriver(driver);

        open(url);
    }

    @AfterMethod
    public static void teardown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @Test
    public static void loginWithValidCredentials() {
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage loginPage = new LoginPage();
        loginPage.attemptLogin(disabledEmail, correctPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedMessage);

    }

    @Test
    public static void sortByNameTest() {
        HeaderMenu headerMenu = new HeaderMenu();
        CatalogPage catalogPage = new CatalogPage();

        headerMenu.goToRubberDucksPage();
        catalogPage.sortByName();
    }

    @Test
    public static void catalogPageLinkTest() {
        HeaderMenu headerMenu = new HeaderMenu();
        CatalogPage catalogPage = new CatalogPage();

        headerMenu.goToRubberDucksPage();
        catalogPage.hasLoaded();
    }
}

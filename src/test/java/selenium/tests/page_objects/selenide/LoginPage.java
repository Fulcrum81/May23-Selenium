package selenium.tests.page_objects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    Logger LOG = Logger.getLogger(LoginPage.class);

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By errorMessage = By.cssSelector("div.notice.errors");

    public void attemptLogin(String email, String password) {
        LOG.info("Attempting login");
        LOG.debug("Inputing username");
        $(emailInput).sendKeys(email);
        LOG.debug("inputing password");
        $(passwordInput).sendKeys(password);
        LOG.debug("clicking login button");
        $(loginButton).click();
    }

    public String getErrorMessageText() {
        $(errorMessage).should(Condition.appear);

        $(errorMessage).shouldNotHave(cssClass("class"));

        WebDriver driver = WebDriverRunner.getWebDriver();

        driver.manage().window().maximize();
        return $(errorMessage).getText();
    }

}

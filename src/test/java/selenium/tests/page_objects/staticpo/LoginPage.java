package selenium.tests.page_objects.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.tests.page_objects.staticpo.locators.Locators;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static selenium.tests.page_objects.staticpo.WebDriverContainer.getDriver;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessage = By.cssSelector("div.notice.errors");

    public static void attemptLogin(String email, String password) {
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }

    public static String getErrorMessageText() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        String errorMessageText = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();

        return errorMessageText;
    }

}

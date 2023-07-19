package selenium.tests.page_objects.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By errorMessage = By.cssSelector("div.notice.errors");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String errorMessageText = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();

        return errorMessageText;
    }

}

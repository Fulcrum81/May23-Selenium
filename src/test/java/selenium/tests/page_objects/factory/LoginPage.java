package selenium.tests.page_objects.factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(css = "div.notice.errors")
    private WebElement errorMessage;

    public void attemptLogin(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }

}

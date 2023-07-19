//package selenium.tests.page_objects.htmlelements.blocks;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import ru.yandex.qatools.htmlelements.annotations.Name;
//import ru.yandex.qatools.htmlelements.element.HtmlElement;
//
//@Name("Login block")
//@FindBy(id="box-account-login")
//public class LoginBlock extends HtmlElement {
//
//    @Name("Email input")
//    @FindBy(name = "email")
//    private WebElement emailInput;
//
//    @Name("Password input")
//    @FindBy(name = "password")
//    private WebElement passwordInput;
//
//    @Name("Login button")
//    @FindBy(name = "login")
//    private WebElement loginButton;
//
//    @Name("Error message")
//    @FindBy(css = "div.notice.errors")
//    private WebElement errorMessage;
//
//    public void attemptLogin(String email, String password) {
//        emailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//    }
//
//    public String getErrorMessageText() {
//
//        return errorMessage.getText();
//    }
//
//}

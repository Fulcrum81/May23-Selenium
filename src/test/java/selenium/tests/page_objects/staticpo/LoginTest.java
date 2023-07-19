package selenium.tests.page_objects.staticpo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static String disabledEmail = "vadim.zubovich@gmail.com";
    private static String correctPassword = "Test1234!";

    private static String incorrectPassword = "akljsdfhsaklhjf";


    @Test
    public static void loginWithValidCredentials() throws InterruptedException {
        String expectedMessage = "Wrong password or the account is disabled, or does not ex!!!ist";

        LoginPage.attemptLogin(disabledEmail, correctPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(), expectedMessage);
    }

    @Test
    public static void sortByNameTest() {
        HeaderMenu.goToRubberDucksPage();
        CatalogPage.sortByName();
    }

    @Test
    public static void catalogPageLinkTest() {
        HeaderMenu.goToRubberDucksPage();
        Assert.assertTrue(CatalogPage.hasLoaded());
    }
}

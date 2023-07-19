//package selenium.tests.page_objects.flow;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class LoginTest {
//
//    private static String disabledEmail = "vadim.zubovich@gmail.com";
//    private static String correctPassword = "Test1234!";
//
//    private static String incorrectPassword = "akljsdfhsaklhjf";
//    private static String url = "https://litecart.stqa.ru/en/";
//
//    private static WebDriver driver;
//
//    @BeforeMethod
//    public static void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(url);
//    }
//
//    @AfterMethod
//    public static void teardown() {
//        driver.quit();
//    }
//
//    @Test
//    public static void loginWithValidCredentials() {
//        String expectedMessage = "Wrong password or the account is disabled, or does not exist";
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage
//                .attemptLogin(disabledEmail, correctPassword)
//                .validateErrorMessageText(expectedMessage);
//    }
//
//    @Test
//    public static void sortByNameTest() {
//        HeaderMenu headerMenu = new HeaderMenu(driver);
//
//        headerMenu
//                .goToRubberDucksPage()
//                .sortByName();
//    }
//}

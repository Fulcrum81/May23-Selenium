//package selenium.tests.page_objects.factory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
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
//
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//
//        loginPage.attemptLogin(disabledEmail, correctPassword);
//        Assert.assertEquals(loginPage.getErrorMessageText(), expectedMessage);
//
//    }
//
//    @Test
//    public static void sortByNameTest() {
//        HeaderMenu headerMenu = PageFactory.initElements(driver, HeaderMenu.class);
//        headerMenu.goToRubberDucksPage();
//
//        CatalogPage catalogPage = PageFactory.initElements(driver, CatalogPage.class);
//        catalogPage.sortByName();
//    }
//}

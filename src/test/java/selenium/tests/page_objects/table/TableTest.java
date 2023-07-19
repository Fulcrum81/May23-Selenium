package selenium.tests.page_objects.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableTest {
    private static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public static void teardown() {
        driver.quit();
    }

    @Test
    public static void tableTest() {
        HomePage homePage = new HomePage(driver);

        System.out.println(homePage.getTable1().getColumnsCount());
        System.out.println(homePage.getTable1().getRowsCount());
        System.out.println(homePage.getTable1().getValueFromCell(3, 4));

    }
}

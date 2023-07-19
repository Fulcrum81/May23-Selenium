package selenium.tests.page_objects.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private Table table1;
    private Table table2;

    private By table1Locator = By.id("table1");
    private By table2Locator = By.id("table2");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        table1 = new Table(driver.findElement(table1Locator));
        table2 = new Table(driver.findElement(table2Locator));
    }

    public Table getTable1() {
        return table1;
    }

    public Table getTable2() {
        return table2;
    }

}

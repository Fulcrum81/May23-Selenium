package selenium.tests.page_objects.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends PageBase {

    private By sortByNameButton = By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        title = "Rubber Ducks | My Store";
    }

    public void sortByName() {
        driver.findElement(sortByNameButton).click();
    }
}

package selenium.tests.page_objects.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage {

    @FindBy(css = "[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']")
    private WebElement sortByNameButton;

    public void sortByName() {
        sortByNameButton.click();
    }
}

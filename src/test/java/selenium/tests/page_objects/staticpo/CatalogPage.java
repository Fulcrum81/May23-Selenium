package selenium.tests.page_objects.staticpo;

import org.openqa.selenium.By;
import selenium.tests.page_objects.staticpo.locators.Locators;

import static selenium.tests.page_objects.staticpo.WebDriverContainer.getDriver;

public class CatalogPage extends PageBase {

    static String title = "Rubber Ducks | My Store";
    private static By sortByNameButton = By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");

    public static boolean hasLoaded() {
        return hasLoaded(title);
    }

    public static void sortByName() {
        getDriver().findElement(sortByNameButton).click();
    }
}

package selenium.tests.page_objects.selenide;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends PageBase {

    Logger LOG = Logger.getLogger(CatalogPage.class);

    private By sortByNameButton = By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");


    public CatalogPage() {
        title = "Rubber Ducks | My Store";
    }

    public void sortByName() {
        LOG.info("Attempting to click sort by name button");
        $(sortByNameButton).click();
    }
}

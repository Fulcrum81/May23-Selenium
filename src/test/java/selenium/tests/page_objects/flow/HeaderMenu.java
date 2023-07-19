package selenium.tests.page_objects.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {

    private By rubberDucksMenuItem = By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public CatalogPage goToRubberDucksPage() {
        driver.findElement(rubberDucksMenuItem).click();
        return new CatalogPage(driver);
    }
}

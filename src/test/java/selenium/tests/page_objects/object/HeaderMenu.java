package selenium.tests.page_objects.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {

    private By rubberDucksMenuItem = By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRubberDucksPage() {
        driver.findElement(rubberDucksMenuItem).click();
    }
}

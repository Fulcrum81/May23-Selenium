package selenium.tests.page_objects.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {

    @FindBy(css = "#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")
    private WebElement rubberDucksMenuItem;

    public void goToRubberDucksPage() {
        rubberDucksMenuItem.click();
    }
}

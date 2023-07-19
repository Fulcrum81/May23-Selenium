package selenium.tests.page_objects.selenide;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {
    Logger LOG = Logger.getLogger(HeaderMenu.class);
    private By rubberDucksMenuItem = By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");


    public void goToRubberDucksPage() {
        LOG.info("Attempting to click rubber ducks menu item");
        $(rubberDucksMenuItem).click();
    }
}

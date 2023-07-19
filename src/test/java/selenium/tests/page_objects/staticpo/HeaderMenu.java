package selenium.tests.page_objects.staticpo;

import org.openqa.selenium.By;

import static selenium.tests.page_objects.staticpo.WebDriverContainer.getDriver;

public class HeaderMenu {

    private static By rubberDucksMenuItem = By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");
    public static void goToRubberDucksPage() {
        getDriver().findElement(rubberDucksMenuItem).click();
    }
}

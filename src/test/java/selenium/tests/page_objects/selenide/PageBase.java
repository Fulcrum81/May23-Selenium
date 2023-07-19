package selenium.tests.page_objects.selenide;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.title;

public class PageBase {

    protected String title;

    public boolean hasLoaded() {
        return title().equals(title);
    }
}

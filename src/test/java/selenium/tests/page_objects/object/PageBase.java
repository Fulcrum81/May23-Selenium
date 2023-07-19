package selenium.tests.page_objects.object;

import org.openqa.selenium.WebDriver;

public class PageBase {

    protected String title;

    public boolean hasLoaded(WebDriver driver) {
        return driver.getTitle().equals(title);
    }
}

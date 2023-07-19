package selenium.tests.page_objects.staticpo;

import static selenium.tests.page_objects.staticpo.WebDriverContainer.getDriver;

public class PageBase {
    protected static boolean hasLoaded(String title) {
        return getDriver().getTitle().equals(title);
    }
}

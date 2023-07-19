package selenium.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyTest {

    @Test
    public static void firstSeleniumTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));



        String searchText = "Purple";

        driver.get("https://litecart.stqa.ru/en/");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));

        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);

        WebElement detailsTab = driver.findElement(By.cssSelector(".tabs a[href$='tab-details']"));
        detailsTab.click();

        WebElement bodyColorLabel = driver.findElement(By.xpath("//*[@id='tab-details']//*[text()='Body:']/following-sibling::td"));

        Assert.assertEquals(bodyColorLabel.getText(), searchText);

//        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public static void doubleClickTest() {
        String expectedImageSource = "http://www.pbclibrary.org/mousing/images/mess1.gif";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://www.pbclibrary.org/mousing/click3.htm");

        WebElement ieIcon = driver.findElement(By.name("icon1"));

        Actions dblClickIeIcon = new Actions(driver);

        dblClickIeIcon.doubleClick(ieIcon).perform();

        WebElement ieMessage = driver.findElement(By.name("mess1"));

        Assert.assertEquals(ieMessage.getAttribute("src"), expectedImageSource);

        driver.quit();
    }

    @Test
    public static void dragNDropTest() {

        String expectedColor = "rgba(255, 192, 203, 1)";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.getTitle();

        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));

        Actions builder = new Actions(driver);

        builder.dragAndDrop(ball, goal).perform();

        builder.contextClick()
                .keyDown(Keys.CONTROL)
                .click()
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertEquals(goal.getCssValue("background-color"), expectedColor);

        driver.quit();
    }

    @Test
    public static void confirmOkTest() {
        String expectedResultText = "You clicked: Ok";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), expectedResultText);

        driver.quit();
    }

    @Test
    public static void confirmCancelTest() {
        String expectedResultText = "You clicked: Cancel";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), expectedResultText);

        driver.quit();
    }

    @Test
    public static void selectTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByValue("2");


    }

    @Test
    public static void fluentWaitTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        JavascriptExecutor js = (JavascriptExecutor)driver;
                        return (Boolean)js.executeScript("return jQuery.active == 0");
                    }
                });
    }

    @Test
    public static void framesTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.tagName("body"));

        System.out.println(left.getText());

    }

    @Test
    public static void multitabTest() {
        String expectedOldText = "Opening a new window";
        String expectedNewText = "New Window";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/windows");

        String initialWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector("#content a")).click();

        String newWindow = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newWindow);

        WebElement newWindowHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(newWindowHeader.getText(), expectedNewText);

        driver.close();

        driver.switchTo().window(initialWindow);
        WebElement initialWindowHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(initialWindowHeader.getText(), expectedOldText);
    }

    @Test
    public static void shadowRootTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://canvas.apps.chrome/");

        //waitForJQuery(driver);
        Thread.sleep(2000);

        SearchContext drawingAppRoot = getShadowRoot(driver, By.id("drawing-app"));

        WebElement welcomeDialog = drawingAppRoot.findElement(By.cssSelector("welcome-dialog"));
        SearchContext welcomeDialogRoot = getShadowRoot(driver, welcomeDialog);

        WebElement getStartedButton = welcomeDialogRoot.findElement(By.cssSelector("#get-started"));

        getStartedButton.click();
    }

    public static SearchContext getShadowRoot(WebDriver driver, By locator) {
        return (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", driver.findElement(locator));
    }

    public static SearchContext getShadowRoot(WebDriver driver, WebElement element) {
        return (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
    }

    public static void waitForJQuery(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            }
        });
    }
}

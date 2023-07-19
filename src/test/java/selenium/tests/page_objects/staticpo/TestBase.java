package selenium.tests.page_objects.staticpo;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static selenium.tests.page_objects.staticpo.WebDriverContainer.getDriver;
import static selenium.tests.page_objects.staticpo.WebDriverContainer.quitDriver;

public class TestBase {
    private static String url = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public static void setup() {
        getDriver().get(url);
    }

    @AfterMethod
    public static void teardown(/*TestResult testResult*/) {
//        if (testResult.getStatus() == TestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Allure.addAttachment("screenshot", new FileInputStream(screenshot));
//                ReportPortal.emitLog(testResult.getTestCaseName(), "ERROR", Calendar.getInstance().getTime(), screenshot);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
//        }
        quitDriver();
    }
}

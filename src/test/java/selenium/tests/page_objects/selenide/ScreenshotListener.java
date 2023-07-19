package selenium.tests.page_objects.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

public class ScreenshotListener implements TestLifecycleListener {

    public ScreenshotListener() {

    }

    @Override
    public void beforeTestStop(TestResult result) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!+++++++++++++++++=======================================Listener active");
        if(result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Allure.addAttachment(result.getTestCaseName(), new FileInputStream(screenshot));
                ReportPortal.emitLog(result.getTestCaseName(), "ERROR", Calendar.getInstance().getTime(), screenshot);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

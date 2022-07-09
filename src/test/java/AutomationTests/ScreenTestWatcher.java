package AutomationTests;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.reflect.Method;

import static AutomationTests.BaseSetup.driver;

public class ScreenTestWatcher implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext)  {
        Method method = extensionContext.getRequiredTestMethod();
        if (extensionContext.getExecutionException().isPresent()){
            makeScreenshot(method.getName());
        }
    }
    @Attachment(value = "{testName} - screen",type = "image/png")
    private byte[] makeScreenshot(String testName){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
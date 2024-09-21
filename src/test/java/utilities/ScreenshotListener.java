package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotListener implements ITestListener {

    public static WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult){

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult){

    }
    @Override
    public void onTestSkipped(ITestResult iTestResult){

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult iTestResult){

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot and save it locally
        saveScreenshotToFile(result.getMethod().getMethodName());

        saveScreenshotToAllure();
    }

    @Attachment(value = "screenshot on failure", type = "image/png", fileExtension = ".png")
    public byte[] saveScreenshotToAllure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void saveScreenshotToFile(String methodName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + methodName + ".png"));
            System.out.println("Screenshot saved: " + methodName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

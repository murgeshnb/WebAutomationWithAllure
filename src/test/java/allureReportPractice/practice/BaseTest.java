package allureReportPractice.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.ScreenshotListener;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    ScreenshotListener screenshotListener;

    @BeforeClass
    public void launchBrowser(){
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenshotListener.driver = driver;

        driver.get("https://www.lambdatest.com/intl/en-in");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BM");
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        this.screenshotListener = new ScreenshotListener();
        screenshotListener.saveScreenshotToAllure();
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}

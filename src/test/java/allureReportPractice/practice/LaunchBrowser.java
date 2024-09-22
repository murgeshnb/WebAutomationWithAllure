package allureReportPractice.practice;

import io.qameta.allure.Attachment;
import io.qameta.allure.Flaky;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class LaunchBrowser extends BaseTest{

    @Test(description = "Launch Browser")
    public void test1() throws InterruptedException {
        By bookDemoButton = RelativeLocator.with(By.xpath("//button[.='Book a Demo']")).toRightOf(By.xpath("//a[.='Login']"));
        driver.findElement(bookDemoButton).click();
        System.out.println("Clicked on demo");
        Thread.sleep(2000);
    }

    @Flaky
    @Test
    public void test2(){
        System.out.println("test 2");
    }

    @Test
    public void test3(){
        System.out.println("test 3");
        Assert.assertTrue(2==3);
    }




}

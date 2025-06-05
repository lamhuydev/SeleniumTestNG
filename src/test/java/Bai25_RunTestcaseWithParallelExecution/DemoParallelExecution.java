package Bai25_RunTestcaseWithParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoParallelExecution {

    @Test
    public void EdgeBrowser() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }


    @Test
    public void ChromeBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }

}

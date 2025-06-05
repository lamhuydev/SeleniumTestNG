package Bai15_DemoExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void demoExplicitWait(){

        driver.get("https://hrm.anhtester.com/erp/login");

        // handle explicitWait
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));

        // wait until locator id = iusername visible
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='iusername']")));
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ipassword']")));
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");

        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Projects']")));
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

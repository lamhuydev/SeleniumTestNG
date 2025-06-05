package Bai9_TestNGFramewok;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTestNG {
    WebDriver driver;


    // beforeMethod dùng để chạy trước các hàm Test
    @BeforeMethod
    public void createDriver(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void loginCRM() throws InterruptedException {
//        driver.get("https://anhtester.com/");
//        driver.findElement(By.xpath("//a[normalize-space()='contact']")).click();
//        Thread.sleep(2000);
        System.out.println("Check login on crm.anhtester.com page");
    }


    @Test
    public void searchOnGoogle() throws InterruptedException {
//        driver.get("https://www.google.com/");
//        driver.findElement(By.xpath("//textarea[@title='Tìm kiếm' and @id = 'APjFqb']")).sendKeys("anh tester", Keys.ENTER);
//        Thread.sleep(2000);
        System.out.println("Search 'Anh tester' on Google");
    }

    @Test
    public void createUser() {
        System.out.println("Test Create User");
    }


    // AfterMethod dùng để chạy sau các hàm Test
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}

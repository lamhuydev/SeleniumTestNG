package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Map;


public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("edge")String browser) {
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));\
        setupDriver(browser);
    }

    public WebDriver setupDriver(String browser){

        switch (browser.trim().toLowerCase()){
            case "chrome":
                driver = initChrome();
                System.out.println("Run with Chrome browser");
                break;
            case "edge":
                driver = initEdge();
                System.out.println("Run with Edge browser");
                break;
            default:
                System.out.println("Run with Edge browser (default)");
                driver = initEdge();
                break;
        }
        return driver;
    }

    public WebDriver initChrome(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver initEdge(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin");
        driver.findElement(By.xpath("//input[@type='email' and @id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password' and @id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit' and normalize-space()='Login']")).click();
    }
}

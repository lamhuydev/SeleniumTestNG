package Bai22_23_HamChung_WebUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;


    private String titleExpected = "Dashboard";
    private By buttonDashboardOption = By.xpath("//div[normalize-space()='Dashboard Options']");

    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void verifyDashboardPage(){
        String titleActual = driver.getTitle();
        Assert.assertEquals(titleActual, titleExpected, "Title page incorrect");
        Assert.assertTrue(driver.findElement(buttonDashboardOption).isDisplayed(), "Dashboard option is not displayed");
    }
}

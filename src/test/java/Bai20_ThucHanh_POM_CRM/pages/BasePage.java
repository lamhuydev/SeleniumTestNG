package Bai20_ThucHanh_POM_CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By iconProfile = By.xpath("//li[contains(@class, 'header-user-profile')]");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//span[@class='menu-text'][normalize-space()='Sales']");
    public By menuProposal = By.xpath("//span[normalize-space()='Proposal']");

    public CustomerPage clickCusomerPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCustomers));
        driver.findElement(menuCustomers).click();

        return new CustomerPage(driver);
    }
}

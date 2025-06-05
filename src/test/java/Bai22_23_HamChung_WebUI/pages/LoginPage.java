package Bai22_23_HamChung_WebUI.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebUI(driver);
    }

    private void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLogin() {
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess() {
        WebUI.sleep(2);
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Login failed");
    }

    public void verifyLoginFailed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Login failed");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "unmatch error message");
    }

    public void loginCRM(String email, String password) {
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        setEmail(email);
        setPassword(password);
        clickLogin();

    }

    public DashboardPage loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        setEmail("admin@example.com");
        setPassword("123456");
        clickLogin();
        verifyLoginSuccess();


        // liên kết với DashboardPage
        return new DashboardPage(driver);

    }
}

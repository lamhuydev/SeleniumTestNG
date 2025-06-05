package Bai18_PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

//    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
//    private By inputEmail = By.xpath("//input[@id='email']");
//    private By inputPassword = By.xpath("//input[@id='password']");
//    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    private By errorMessage = By.xpath("//div[@id='alerts']");

    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerPage;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@id='alerts']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    private void setEmail(String email) {
        inputEmail.sendKeys(email);
    }

    private void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    private void clickLogin() {
        buttonLogin.click();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Login failed");
    }

    public void verifyLoginFailed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Login failed");
        Assert.assertTrue(errorMessage.isDisplayed(), "");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "unmatch error message");
    }

    public void loginCRM(String email, String password) {
        driver.get("https://crm.anhtester.com/admin/authentication");
        setEmail(email);
        setPassword(password);
        clickLogin();
    }
}

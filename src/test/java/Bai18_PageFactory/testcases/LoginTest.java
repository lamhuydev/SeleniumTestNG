package Bai18_PageFactory.testcases;

import Bai18_PageFactory.pages.LoginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginFailWithErrorEmail() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFailed();
    }

    @Test
    public void loginFailWithErrorPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFailed();
    }


}

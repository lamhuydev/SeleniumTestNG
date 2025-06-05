package Bai22_23_HamChung_WebUI.testcases;

import Bai22_23_HamChung_WebUI.pages.DashboardPage;
import Bai22_23_HamChung_WebUI.pages.LoginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void verifyDashboardPage(){

        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPage();

    }

}

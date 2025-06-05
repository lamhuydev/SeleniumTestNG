package Bai20_ThucHanh_POM_CRM.testcases;

import Bai20_ThucHanh_POM_CRM.pages.DashboardPage;
import Bai20_ThucHanh_POM_CRM.pages.LoginPage;
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

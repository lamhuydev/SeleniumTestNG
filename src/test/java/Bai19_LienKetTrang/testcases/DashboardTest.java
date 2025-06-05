package Bai19_LienKetTrang.testcases;

import Bai19_LienKetTrang.pages.DashboardPage;
import Bai19_LienKetTrang.pages.LoginPage;
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

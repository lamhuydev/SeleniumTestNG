package Bai14_JsExecutor;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo_JsExecutor extends BaseTest {

    @Test
    public void demoScrollToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement titleScrollTo = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        // executeScript dùng để thực hiện cú pháp của JavascriptExecutor
        js.executeScript("arguments[0].scrollIntoView(false);", titleScrollTo);
        Thread.sleep(2000);
    }

    @Test
    public void demoHighlightElement() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputHighlight = driver.findElement(By.xpath("//input[@id='email']"));

        js.executeScript("arguments[0].style.border='5px solid red'", inputHighlight);

        Thread.sleep(3000);

    }

}

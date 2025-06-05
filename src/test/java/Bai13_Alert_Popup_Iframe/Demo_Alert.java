package Bai13_Alert_Popup_Iframe;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Demo_Alert extends BaseTest {
    @Test
    public void demoDismissAlert() throws InterruptedException {
        driver.get("https://demoqa.com/");
        Actions actions = new Actions(driver);
        WebElement alert_popup_iframe_button = driver.findElement(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']/ancestor::div[@class='card mt-4 top-card']"));
        actions.click(alert_popup_iframe_button).perform();

        Thread.sleep(2000);

        WebElement alertMenu = driver.findElement(By.xpath("//span[normalize-space()='Alerts']"));
        actions.click(alertMenu).perform();

        Thread.sleep(2000);

        WebElement alertButton = driver.findElement(By.xpath("//span[normalize-space()='Click Button to see alert']/following::button[@id='alertButton']"));
        actions.click(alertButton).perform();

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
    }

    @Test
    public void demoAcceptAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Actions actions = new Actions(driver);


        WebElement alertButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertButton);

        actions.click(alertButton).perform();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement confirmResult = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String resultText = confirmResult.getText();

        Assert.assertTrue(resultText.contains("Ok"), "The message result unmatch");
        Thread.sleep(2000);

    }


    @Test
    public void demoSenkeysAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Actions actions = new Actions(driver);


        WebElement alertButton = driver.findElement(By.xpath("//button[@id='promtButton']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertButton);

        actions.click(alertButton).perform();

        Thread.sleep(2000);

        String getTextAlert = driver.switchTo().alert().getText();
        System.out.println(getTextAlert);

        driver.switchTo().alert().sendKeys("selenium");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement promptResult = driver.findElement(By.xpath("//span[@id='promptResult']"));
        String resultText = promptResult.getText();

        Assert.assertTrue(resultText.contains("selenium"), "The message result unmatch");
        Thread.sleep(2000);

    }
}

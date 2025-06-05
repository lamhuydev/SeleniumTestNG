package Bai13_Alert_Popup_Iframe;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class DemoPopupWindow extends BaseTest {
    @Test
    public void testOpenNewTab() {
        driver.get("https://anhtester.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
    }

    @Test
    public void testOpenNewWindow() throws InterruptedException {
        driver.get("https://anhtester.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }

    @Test
    public void testSwitchToTabWithPosition() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");


        WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTabButton.click();

        String mainIDDirver = driver.getWindowHandle();

        Set<String> idAllDriver = driver.getWindowHandles();

        String idTabDriver_2 = (String) idAllDriver.toArray()[1];

        driver.switchTo().window(idTabDriver_2);

        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(mainIDDirver);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Browser Windows']")).getText());

        Thread.sleep(2000);

    }

    @Test
    public void demoSwitchToTabWithFor() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTabButton.click();

        String mainIdTab = driver.getWindowHandle();
        System.out.println("Main id tab: " + mainIdTab);
        Set<String> allIdTab = driver.getWindowHandles();

        for (String allId : allIdTab) {
            if(!allId.equals(mainIdTab)){
                driver.switchTo().window(allId);

                System.out.println("This is second tab");
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
            }else{
                System.out.println("Main id tab in condition: " + allId);
            }
        }
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(mainIdTab);
        System.out.println("This is main tab");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }
}

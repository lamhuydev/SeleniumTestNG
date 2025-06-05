package Bai13_Alert_Popup_Iframe;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo_Iframe extends BaseTest {

    @Test
    public void demoIframe(){
        driver.get("https://demoqa.com/frames");
        // chuyển hướng handle sang iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement headingIframeText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println("Text inside iframe method: " + headingIframeText.getText());

        // parentFrame dùng để chuyển hướng sang thuộc tính ngoài iframe
        driver.switchTo().parentFrame();
        System.out.println("Text outside iframe method: " + driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText());
    }

}

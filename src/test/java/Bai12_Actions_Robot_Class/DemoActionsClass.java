package Bai12_Actions_Robot_Class;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class DemoActionsClass extends BaseTest {

    @Test(priority = 2)
    public void testSenKeys() throws InterruptedException {

        driver.navigate().to("https://www.google.com/");


        // Khai báo Actions Class
        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.xpath("//textarea[@name='q']"));

        actions.sendKeys(webElement, "Anh tester").perform();

        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
        driver.navigate().to("https://anhtester.com/");

        Assert.assertEquals(driver.getTitle(), "Anh Tester Automation Testing", "Actual Title Unmatch With Expected Title");
        Thread.sleep(1000);

    }


    @Test(priority = 3)
    public void testDoubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");

        Actions actions = new Actions(driver);

        WebElement contact = driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        actions.doubleClick(contact).perform();

        Thread.sleep(3000);
    }


    @Test
    public void testContextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");

        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.xpath("//a[normalize-space()='contact']"));
        actions.contextClick(webElement).perform();

        Thread.sleep(3000);
    }


    @Test
    public void testMoveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");

        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.xpath("//h2[normalize-space()='Blog Testing']"));

        // moveToElement là di chuyển hay cuộn chuột đến vị trí của element
        actions.moveToElement(webElement).perform();
        // dragAndDrop() có tham số bên trong hiểu như là From, To
        // From element này, Đến (To) element kia
        //actions.dragAndDrop(WebElement source, WebElement target);

        Thread.sleep(2000);
    }


    @Test
    public void testDragAndDrop() throws InterruptedException {
//        driver.get("https://crm.anhtester.com/admin/authentication");

        loginCRM();


        Actions actions = new Actions(driver);

        // click menu task
        WebElement taskMenu = driver.findElement(By.xpath("//span[normalize-space()='Tasks']"));

        actions.click(taskMenu).perform();


        // click kanban
        WebElement buttonKanBan = driver.findElement(By.xpath("//a[normalize-space()='New Task']//following-sibling::a"));

        actions.click(buttonKanBan).perform();


        WebElement from = driver.findElement(By.xpath("//li[@data-task-id='85']"));
        WebElement to = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@class='content']/div[@class='row']/div[@class='col-md-12']/div[@id='kan-ban-tab']/div[@class='row']/div[@class='container-fluid']/div[@id='kan-ban']/ul[1]/li[1]/div[1]/div[1]"));


        Thread.sleep(2000);

        actions.dragAndDrop(from, to).perform();
        Thread.sleep(2000);
    }

    @Test
    public void testKeyDown() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");


        // Khai báo Actions Class
        Actions actions = new Actions(driver);

        WebElement webElement = driver.findElement(By.xpath("//textarea[@name='q']"));

        // keyDown tức là đè một phím nào đó trên bàn phím,
        // như trường hợp ví dụ thì keyDown đang thực hiện đè phím SHIFT

        // build dùng để nối nhiều phương thức actions class lại với nhau
        // keyUp tức bỏ đè phím đó. Tham số keyDown đang đề phím nào thì keyUp truyền phím đó
        actions.keyDown(webElement, Keys.SHIFT).sendKeys("anh tester").keyUp(Keys.SHIFT).build().perform();


        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void demoActionClass() throws InterruptedException {

        Actions actions = new Actions(driver);
        loginCRM();

        // click menu task
        WebElement taskMenu = driver.findElement(By.xpath("//span[normalize-space()='Tasks']"));

        actions.click(taskMenu).perform();

        // click kanban
        WebElement buttonKanBan = driver.findElement(By.xpath("//a[normalize-space()='New Task']//following-sibling::a"));

        actions.click(buttonKanBan).perform();


        WebElement from = driver.findElement(By.xpath("//li[@data-task-id='85']"));

        WebElement to = driver.findElement(By.xpath("//li[@data-task-id='47']/parent::ul"));

        actions.dragAndDrop(from, to).perform();

        Thread.sleep(3000);

//        closeDriver();

    }

    @Test
    public void testCopyPaste() throws InterruptedException {
        driver.navigate().to("https://anhtester.com/");

        Actions action = new Actions(driver);

        WebElement inputSearch = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement blogPage = driver.findElement(By.xpath("//a[normalize-space()='blog']"));



//        action.click(inputSearch).perform();

        action.sendKeys(inputSearch, "selenium").perform();

        Thread.sleep(3000);

        action.keyDown(Keys.CONTROL).sendKeys(inputSearch, "a").sendKeys(inputSearch, "x").build().perform();
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);
        action.click(blogPage).perform();

        WebElement titleSearchBlog = driver.findElement(By.xpath("//h1[normalize-space()='All Blogs']"));


        action.click(titleSearchBlog).perform();
        WebElement inputSearchBlog = driver.findElement(By.xpath("//input[contains(@placeholder,'Tìm kiếm bài viết . . .')]"));

        Thread.sleep(3000);
        action.keyDown(Keys.CONTROL).sendKeys(inputSearchBlog, "V").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(3000);

    }
}

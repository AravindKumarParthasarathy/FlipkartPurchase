package flipkartautomation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPurchase {

    public static void FlipkartPurchase() throws Exception {

        //Chrome Driver Installation and the chrome driver path would vary based on the location it can be given as a proprty file too
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CECH0206\\Downloads\\AravindPersonal\\chromedriver\\chromedriver.exe");
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(handlingSSL);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // opening browser and searching for flipkart and search for item iphone13
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("iphone13");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys(Keys.RETURN);

        //clicking on the first item appears on search
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();



        ArrayList < String > newTb = new ArrayList < String > (driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));

        //Debugging code
        //String strUrl = driver.getCurrentUrl();
        //System.out.println(strUrl);

        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]")));




        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]"));
        String priceofonequantity = (webElement.getText());

        System.out.println("Price of Single Piece Iphone 13 is: " + priceofonequantity);


        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();



        Thread.sleep(8000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        //debugging code
        //String currenturl = driver.getCurrentUrl();
        //System.out.println(currenturl);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".\\_23FHuj:nth-child(3)")));

        driver.findElement(By.cssSelector(".\\_23FHuj:nth-child(3)")).click();


        Thread.sleep(8000);

        WebElement cartpage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[5]/div/span/div/div/span"));
        String twoquantity = (cartpage.getText());

        System.out.println("Price of 2 Quantities of Iphone13: " + twoquantity);
        driver.quit();

    }


    public static void main(String[] args) throws Exception {

        FlipkartPurchase();

    }


}

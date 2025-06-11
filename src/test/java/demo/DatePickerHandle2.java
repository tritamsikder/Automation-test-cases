package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandle2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();
        
        // Click "Both"
        driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();

        // Click the date picker using JavaScript if it's not directly clickable
        WebElement departureInput = driver.findElement(By.xpath("//input[@placeholder='Departure Date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureInput);
        
        Thread.sleep(2000);
//        driver.quit();
    }
}

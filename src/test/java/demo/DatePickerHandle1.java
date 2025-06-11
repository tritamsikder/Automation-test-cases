package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerHandle1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dummy-tickets.com/buyticket");
        driver.manage().window().maximize();

        // Clicking on 'Both'
        driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Both']"))).click();

        // Entering 'from' location
        WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='source[]'])[4]")));
        fromInput.sendKeys("te");

//        // Selecting 'from' airport from suggestions
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='suggestions-list']//li//p")));
        List<WebElement> fromList = driver.findElements(By.xpath("//ul[@class='suggestions-list']//li//p"));
        for (WebElement from : fromList) {
            if (from.getText().trim().equals("Aalborg Airport,")) {
                js.executeScript("arguments[0].scrollIntoView(true);", from);
                wait.until(ExpectedConditions.elementToBeClickable(from)).click();
                break;
            }
        }

//        // Entering 'to' location
        WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='destination[]'])[4]")));
        toInput.clear();
        toInput.sendKeys("te");

        // Wait for suggestions to appear
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='suggestions-list']//li//p")));
        List<WebElement> toList = driver.findElements(By.xpath("//ul[@class='suggestions-list']//li//p"));
        for (WebElement to : toList) {
            System.out.println(to.getText().trim());
            if (to.getText().trim().equals("Anaa Airport,")) {
                js.executeScript("arguments[0].scrollIntoView(true);", to);
                wait.until(ExpectedConditions.elementToBeClickable(to)).click();
                break;
            }
        }
        
        //Clicking on Departure time date picker
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(
        	    By.xpath("//div[@class='col-sm-12 p-0']/input[@placeholder='Departure Date']")
        	));
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);


        Thread.sleep(3000); // Just to see the result before closing
//        driver.quit();
    }
}

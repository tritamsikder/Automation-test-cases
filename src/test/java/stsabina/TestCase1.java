package stsabina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-stsabinaparish.webgen.me/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act = new Actions(driver);

        int totalItems = driver.findElements(By.xpath("//span[normalize-space()='Ministries']/../following-sibling::ul/li")).size();

        for (int i = 1; i <= totalItems; i++) {
            // Re-locate the dropdown each time due to DOM refresh after navigating back
            WebElement ministriesDropdown = driver.findElement(By.xpath("//span[normalize-space()='Ministries']"));
            act.moveToElement(ministriesDropdown).perform();
            Thread.sleep(1000); // Allow dropdown to display

            WebElement item = driver.findElement(By.xpath("(//span[normalize-space()='Ministries']/../following-sibling::ul/li)[" + i + "]"));
            item.click();

            Thread.sleep(2000); // Let the new page load
            driver.navigate().back(); // Go back to homepage
            Thread.sleep(2000); // Wait for page to reload
        }

        driver.quit();
    }
}

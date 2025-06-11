package tcg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tcgdigital.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test(priority = 1)
    public void f() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        // Store size once since it might change after navigation
        List<WebElement> initialLinks = driver.findElements(By.xpath("//ul[@id='menu-about-us']//li"));
        int count = initialLinks.size();

        for (int i = 0; i < count; i++) {
            // Re-find elements each loop to avoid stale references
            List<WebElement> quickLinks = driver.findElements(By.xpath("//ul[@id='menu-about-us']//li"));

            WebElement link = quickLinks.get(i);
            String linkText = link.getText();
            System.out.println("Clicking: " + linkText);

            link.click();
            Thread.sleep(2000);

            String currentPageURL = driver.getCurrentUrl();
            Assert.assertNotEquals(currentPageURL, "https://www.tcgdigital.com/", "Navigation failed for: " + linkText);

            driver.navigate().back();
            Thread.sleep(3000);
        }
    }
}

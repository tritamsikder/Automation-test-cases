package hypeU;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindTexts {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hypeuwebstaging.webgen.me/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Handle "Allow" popup (if exists)
        try {
            WebElement allowButton = driver.findElement(By.xpath("//button[.='Allow']"));
            allowButton.click();
        } catch (Exception e) {
            System.out.println("Notification popup not present or already dismissed.");
        }

        Thread.sleep(3000);

        // Perform login
        driver.findElement(By.xpath("//input[@placeholder='example@email.com']"))
              .sendKeys("tritam@webgentechnologies.com");
        driver.findElement(By.xpath("//input[@placeholder='At least 6 characters']"))
              .sendKeys("Test@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for homepage to load completely and loader to disappear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.full_screen_loader")));

        // Click on "Mint" tab
        WebElement mintLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Mint']")));
        mintLink.click();

        // Wait again if loader appears after clicking "Mint"
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.full_screen_loader")));

        Thread.sleep(2000);

        // Scroll slowly to bottom to load all dynamic content
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) break;
            lastHeight = newHeight;
        }

        Thread.sleep(2000); // Final wait after scrolling

        // Extract and print all elements with visible non-empty text
        List<WebElement> allTextElements = driver.findElements(By.xpath("//*[normalize-space(text()) != '']"));
        Set<String> printedText = new LinkedHashSet<>();

        System.out.println("\n=== Extracted Texts from Home Page ===");
        for (WebElement element : allTextElements) {
            try {
                String tag = element.getTagName();
                String text = element.getText().trim();
                if (!text.isEmpty() && printedText.add(text)) {
                    System.out.println("<" + tag + ">: " + text);
                }
            } catch (Exception ignored) {
                // Ignore stale elements
            }
        }

        // Clean up
        driver.quit();
    }
}

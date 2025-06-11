package hypeU;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingAlltexts {
    public static void main(String[] args) {
        // Set ChromeDriver path if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://hypeuwebstaging.webgen.me/");

            // Maximize window
            driver.manage().window().maximize();

            // Fill in username
//            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='example@email.com']"));
//            emailField.sendKeys("tritam@webgentechnologies.com");
//
//            // Fill in password
//            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='At least 6 characters']"));
//            passwordField.sendKeys("Test@123");
//
//            // Click login button
//            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//            loginButton.click();

            // Wait for the page to load after login (basic static wait, you can use WebDriverWait instead)
            Thread.sleep(5000); // Adjust or use explicit waits for real projects

            // Extract all non-empty text elements
            List<WebElement> allTextElements = driver.findElements(By.xpath("//*[normalize-space(text()) != '']"));

            System.out.println("Extracted Elements with Tag and Text:");

            for (WebElement element : allTextElements) {
                String tag = element.getTagName();
                String text = element.getText().trim();

                if (!text.isEmpty()) {
                    System.out.println("<" + tag + ">: " + text);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}

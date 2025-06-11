package hypeU;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextExtractor {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Login
            LoginHelper loginHelper = new LoginHelper(driver);
            loginHelper.login(
                "https://hypeuwebstaging.webgen.me/login",
                "tritam@webgentechnologies.com",
                "Test@123"
            );

            // Optional: Wait for post-login content to load
            Thread.sleep(5000);

            // Step 2: Extract all visible elements with non-empty text
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
            driver.quit();
        }
    }
}

package brokenLinkHandle;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLinks {

    public static void main(String[] args) {
        // Launch a new instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait of 10 seconds for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target website
        driver.get("https://www.webgentechnologies.us/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Find all anchor (<a>) tags on the page
        List<WebElement> presentLinks = driver.findElements(By.tagName("a"));

        // Counter to track number of broken links
        int brokenLinkCount = 0;

        // Loop through each link found on the page
        for (WebElement link : presentLinks) {
            // Get the 'href' attribute value
            @SuppressWarnings("deprecation")
			String url = link.getAttribute("href");

            // Skip if href is null or empty
            if (url == null || url.isEmpty() || !(url.startsWith("http"))) {
//                System.out.println("Skipping non-http(s) link: " + url);
                continue;
            }

            try {
                // Create a URL object from the href string
                @SuppressWarnings("deprecation")
				URL linkURL = new URL(url);

                // Open an HTTP connection to the URL
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                conn.setRequestMethod("HEAD"); // Use HEAD to avoid downloading full content
                conn.setConnectTimeout(5000);  // Optional: set timeout
                conn.connect();

                // Check the HTTP response code
                if (conn.getResponseCode() >= 400) {
                    brokenLinkCount++;
                    System.out.println("Broken link: " + url + " | Response Code: " + conn.getResponseCode());
                }

                conn.disconnect(); // Disconnect after checking

            } catch (Exception e) {
                // If an exception occurs (like malformed URL or connection timeout), count as broken
                brokenLinkCount++;
                System.out.println("Exception checking link: " + url + " | " + e.getMessage());
            }
        }

        // Output total number of broken links
        System.out.println("Total broken links found: " + brokenLinkCount);

        // Close the browser
        driver.quit();
    }
}

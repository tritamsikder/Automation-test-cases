package brokenLinkHandle;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class HandleBrokenLink {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.tcgdigital.com/privacy-policy-2/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + allLinks.size());

        int brokenCount = 0;

        for (WebElement link : allLinks) {
            String href = link.getAttribute("href");

            if (href == null || href.trim().isEmpty()) {
                printLinkDetails("Empty or Null HREF", link, -1);
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    brokenCount++;
                    printLinkDetails("Broken Link", link, responseCode);
                }

            } catch (Exception e) {
                System.out.println("\n[Connection Error] for URL: " + href);
                brokenCount++;
            }
        }

        System.out.println("\nTotal number of broken links: " + brokenCount);
        driver.quit();
    }

    private static void printLinkDetails(String label, WebElement link, int responseCode) {
        System.out.println("\n[" + label + "] Element Identified:");
        System.out.println("Text         : " + link.getText());
        System.out.println("Tag Name     : " + link.getTagName());
        System.out.println("Location     : " + link.getLocation());
        System.out.println("Outer HTML   : " + link.getAttribute("outerHTML"));
        if (responseCode != -1) {
            System.out.println("Response Code: " + responseCode);
        }
        System.out.println("URL          : " + link.getAttribute("href"));
    }
}

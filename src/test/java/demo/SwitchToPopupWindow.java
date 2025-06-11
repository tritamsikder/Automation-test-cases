package demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToPopupWindow {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // 1. Store main window handle
        String mainWindow = driver.getWindowHandle();

        // 2. Click the button to open popup
        driver.findElement(By.xpath("//button[@id='PopUp']")).click();
        Thread.sleep(2000); // Let the popup load

        // 3. Get all open windows
        Set<String> allWindows = driver.getWindowHandles();

        // 4. Desired popup title
        String expectedTitle = "Fast and reliable end-to-end testing for modern web apps | Playwright";

        // 5. Switch to the popup window
        for (String window : allWindows) {
            driver.switchTo().window(window);
            String currentTitle = driver.getTitle();
            System.out.println("Checking window: " + currentTitle);

            if (currentTitle.equals(expectedTitle)) {
                System.out.println("Popup window found, closing it.");
                driver.findElement(By.xpath("//a[@class='getStarted_Sjon']")).click();
                Thread.sleep(2000);
                driver.close(); // Close the popup
                break;
            }
        }

        // 6. Switch back to the main window
        driver.switchTo().window(mainWindow);
        System.out.println("Back to main window: " + driver.getTitle());

        Thread.sleep(2000);
        driver.quit();
    }
}


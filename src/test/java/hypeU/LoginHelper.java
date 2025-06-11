package hypeU;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper {
    private WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String url, String username, String password) {
        driver.get(url);
        driver.manage().window().maximize();

        // Enter username
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='example@email.com']"));
        emailField.sendKeys(username);

        // Enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='At least 6 characters']"));
        passwordField.sendKeys(password);

        // Handle optional overlay gracefully
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> overlays = driver.findElements(By.className("notification-overlay"));
            if (!overlays.isEmpty() && overlays.get(0).isDisplayed()) {
                wait.until(ExpectedConditions.invisibilityOf(overlays.get(0)));
            }
        } catch (Exception e) {
            System.out.println("Overlay not visible or already gone, proceeding...");
        }

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
}

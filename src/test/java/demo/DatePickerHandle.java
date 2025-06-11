package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandle {

    // Parameterized method to select date
    public static void selectDate(WebDriver driver, String day, String month, String year) {
        while (true) {
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        // Select the given day
        driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // Switch to iframe containing the date picker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Open the date picker
        driver.findElement(By.id("datepicker")).click();

        // Call the parameterized method
        selectDate(driver, "15", "December", "2027");

        // Close the browser
        Thread.sleep(2000);
        driver.quit();
    }
}

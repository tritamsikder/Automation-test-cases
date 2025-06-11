package webgenUs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://psrassurance.com/");
		driver.manage().window().maximize();
		
		// Accept cookies
		driver.findElement(By.xpath("//span[normalize-space()='Accept all']")).click();
		Thread.sleep(2000);

		// Get a list of hoverable elements (menu items in this case)
		List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@id='menu-main-menu']//li"));

		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement item : menuItems) {
			// Scroll into view (true = align to top of viewport)
			js.executeScript("arguments[0].scrollIntoView(true);", item);
			Thread.sleep(800); // allow time to scroll
			
			// Additional scroll to offset any sticky header (optional)
			js.executeScript("window.scrollBy(0, -100);"); 
			Thread.sleep(800);

			// Slowly hover over the element
			act.moveToElement(item).pause(Duration.ofSeconds(2)).perform();
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		driver.quit();
	}
}

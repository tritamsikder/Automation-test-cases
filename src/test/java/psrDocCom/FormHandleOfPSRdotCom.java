package psrDocCom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormHandleOfPSRdotCom {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://psrassurance.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);

		// Accept cookies
		driver.findElement(By.xpath("//span[normalize-space()='Accept all']")).click();
		Thread.sleep(2000);

		// Fill name, phone, email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys("Test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone']"))).sendKeys("9876543210");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("test@test.com");

		// Click radio button using Actions
		WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='working']")));
		Thread.sleep(1000);
		actions.moveToElement(radioBtn).pause(Duration.ofSeconds(1)).click().build().perform();

		// Fill working details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter working details']"))).sendKeys("Test work");

		// Scroll to dropdown input and click using Actions
		WebElement dropdownInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dropdownInput']")));
		Thread.sleep(2000); // Let page settle if animations
		actions.moveToElement(dropdownInput).pause(Duration.ofMillis(500)).click().build().perform();
		actions.moveToElement(dropdownInput).pause(Duration.ofMillis(500)).click().build().perform();
		
		// Select "Tax Consulting" from dropdown options
		List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@class='dropdown']//div[@class='dropdown-item-div']"));
		for (WebElement item : dropdownList) {
			if (item.getText().equals("Tax Consulting")) {
				item.click();
			}
		}
		
		// Double click the user choice dropdown (assumed to trigger selection/focus)
		WebElement userChoice = driver.findElement(By.xpath("//select[@id='userChoice']"));
		actions.doubleClick(userChoice).build().perform();
		
		// Scroll to submit button and click
		WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']")));
		actions.moveToElement(submitBtn).pause(Duration.ofMillis(500)).click().build().perform();
		
		// Scroll up by 100 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -100);");
		
		// Wait for "Thank You!" message and scroll to it using Actions
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Thank You!']")));
		actions.moveToElement(successMsg).pause(Duration.ofMillis(500)).perform(); // Scrolls to the message
		
		// Validate and print test result
		if (successMsg.isDisplayed()) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case failed");
		}

		// Close browser
		Thread.sleep(2000);
		driver.quit();
	}
}

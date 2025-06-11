package hmcTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.heavymachinerycare.com/contact-us/");
		driver.manage().window().maximize();
			
		//Getting text of all the drop down options
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[contains(@class,'wpcf7-form-control')]/option")));
//		for (WebElement option : options) {
//			System.out.println(option.getText());
//		}
		
		//Clicking each options of the drop down
		WebElement dropdownBtn = driver.findElement(By.xpath("//select[contains(@class,'wpcf7-form-control')]"));
		for (WebElement optn: options) {
			dropdownBtn.click();
			Thread.sleep(1000);
			optn.click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name *']"))).sendKeys("TestFirstName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name *']"))).sendKeys("TestLastName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email *']"))).sendKeys("test@test.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone Number *']"))).sendKeys("9876543210");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Message']"))).sendKeys("Test Message");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by 500 pixels
		js.executeScript("window.scrollBy(0,500)");
		

		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
		
		WebElement test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Message sent successfully. We’ll get back to you soon!']")));
		
		if (test.isDisplayed()) {
			System.out.println("Test Case Pass");
			Thread.sleep(4000);
			driver.quit();
		} else {
			System.out.println("Test Case failed");
			Thread.sleep(4000);
			driver.quit();
		}
		
	}

}

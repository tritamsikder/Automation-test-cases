package webgenUs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPageOfWebgenUS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.webgentechnologies.us/reach-us/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//check navigation bar elements click or not
		List<WebElement> navElements = driver.findElements(By.xpath("//div[@class='header_menu_and_contact']//li//a[@tabindex='0']"));
		for (WebElement item : navElements) {
			if (item != null) {
				item.click();
				if (!driver.getCurrentUrl().equals("https://www.webgentechnologies.us/reach-us/")) {
					Thread.sleep(1000);
					driver.navigate().back();
				}
			}
		}
		
		//Testing the form inputs
		// Locate the element you want to scroll to (e.g., the Name input field)
		WebElement nameField = driver.findElement(By.xpath("//input[@name='Name']"));

		// Scroll to that element using JavaScriptExecutor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameField);

		// Optional: Wait a little for smooth scrolling effect
		Thread.sleep(1000);

		// Now interact with the form
		nameField.sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@name='Phone-number']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("Test Subject");
		driver.findElement(By.xpath("//textarea[@name='Message']")).sendKeys("Test Message");

		
		int num1 = Integer.parseInt(driver.findElement(By.xpath("//span[@class='cf7as-firstAct'][1]")).getText());
		int num2 = Integer.parseInt(driver.findElement(By.xpath("//span[@class='cf7as-firstAct'][2]")).getText());
		System.out.println(num1 +" "+ num2);
		
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[@id='wpcf7-f164-o1']/form/div[7]/p[2]/span[1]")).getText();
		System.out.println(text);
		// Regex to match an operator: +, -, *, or /
		String operator = text.replaceAll("[^+x]", "").trim();

		System.out.println("Operator: " + operator);
		
		int result = 0;
		
		if (operator.equals("+")) {
			result = num1 + num2;
		} else if (operator.equals("x")) {
			result = num1 * num2;
		}
		
		String res = Integer.toString(result);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Type your answer']")).sendKeys(res);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit']"))).click();
		
		try {
		    WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[.='Thank you for your message. It has been sent.']")
		    ));

		    if (popupMessage.isDisplayed()) {
		        System.out.println("Popup success message is displayed.");
		    } else {
		        System.out.println("Popup appeared but is not visible.");
		    }

		} catch (Exception e) {
		    System.out.println("Popup success message not found or not visible.");
		}

		
		Thread.sleep(2000);
		driver.quit();
	}
	

}

package tipsAndTricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().window().maximize();
		
		List<WebElement> AllLabel = driver.findElements(By.xpath("//form[@class='form-horizontal']//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		
		for (WebElement label : AllLabel) {
//			System.out.println(label.getText());
			
//			js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')", label);
			
			String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
			String content = js.executeScript(script, label).toString();
//			System.out.println(content);
			
			if (content.contains("*")) {
				System.out.println(label.getText() + " :Mandatory field");
			} else {
				System.out.println(label.getText() + " :Not mandatory field");
			}
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}

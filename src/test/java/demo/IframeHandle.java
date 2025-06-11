package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		
		for (int i = 0; i < frames.size(); i++) {
			driver.switchTo().frame(i);
			driver.findElement(By.xpath("//input[@type='text' and @size='25']")).sendKeys("Test");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}

package tipsAndTricks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrameWithoutSwitchTo {
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://ui.vision/demo/webtest/frames/");
			driver.manage().window().maximize();
			
//			Way 1
//			WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
//			driver.switchTo().frame(frame1);
//			driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("test");
			
//			Way 2
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));
			driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("test");
			
			Thread.sleep(2000);
			driver.quit();
		}
}

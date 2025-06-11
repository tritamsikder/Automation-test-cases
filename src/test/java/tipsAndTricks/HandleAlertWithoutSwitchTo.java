package tipsAndTricks;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertWithoutSwitchTo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		simpleAlert.click();
		
		
		//Basic way
//		driver.switchTo().alert().accept();
//		Alert al = driver.switchTo().alert();
//		al.accept();
		
		//Trick 1
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert al = wait.until(ExpectedConditions.alertIsPresent());
//		al.accept();

		//Trick 2
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		js.executeScript("window.alert=function{};");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}

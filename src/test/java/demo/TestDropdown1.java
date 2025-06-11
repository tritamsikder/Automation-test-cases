package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDropdown1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
//		locating all options in drop down
		Thread.sleep(2000);
		WebElement empStatus = driver.findElement(By.xpath("//div[@class='oxd-select-text-input' and .='-- Select --' and @tabindex ='0']"));
		empStatus.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@role='listbox']//div[@role='option']"));
		
		
		for (WebElement optn : allOptions) {
			Thread.sleep(2000);
			empStatus.click();
			Thread.sleep(2000);
			optn.click();
			System.out.println(optn.getText());
		}
//		
//		for(int i = 0; i < allOptions.size(); i++) {
//			empStatus.click();
//			Thread.sleep(2000);
//			allOptions.get(i).click();
//		}
//		
	}

}

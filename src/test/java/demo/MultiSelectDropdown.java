package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement optnBtn = driver.findElement(By.xpath("//select[@id='colors']"));
		Select opt = new Select(optnBtn);
//		System.out.println(opt.getOptions().size());
		
		for (int i = 0; i < opt.getOptions().size(); i++) {
			opt.selectByIndex(i);
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

}

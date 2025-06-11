package tipsAndTricks;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateOptionsInListbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		WebElement list = driver.findElement(By.xpath("//select[@id='colors']"));
		WebElement list = driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select dropdownList = new Select(list);
		
		Set<String> uniqueOptions = new HashSet<String>();
		
		boolean flag = false;
		
		for (WebElement option : dropdownList.getOptions()) {
			
			String optionText = option.getText();
			
			if (!uniqueOptions.add(optionText)) {
				System.out.println("Duplicate option found: " + optionText);
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.println("No duplicate options found.");
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}

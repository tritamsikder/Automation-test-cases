package tipsAndTricks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortedOrUnsortedListCheck {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Sorted dropdown
//		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		//unsorted dropdown
		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList =  new ArrayList();
		
		List<WebElement> options = dropDown.getOptions();
		
		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());	
		}
		
		System.out.println("Before sorting....");
		System.out.println(originalList);
		System.out.println(tempList);
		
		Collections.sort(tempList);
		
		System.out.println("After sorting....");
		System.out.println(originalList);
		System.out.println(tempList);
		
		if (originalList.equals(tempList)) {
			System.out.println("List box is sorted...");
		} else {
			System.out.println("List box is not sorted...");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}

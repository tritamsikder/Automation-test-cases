package tipsAndTricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableElementHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-responsive']//tbody/tr"));
		System.out.println("Total no of rows: " + rows.size());
		
		for(int r = 1; r <= rows.size(); r++) {
			WebElement browserName = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+r+"]/td[1]"));
			if (browserName.getText().equals("Chrome")) {
				 String cpuValue = driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(.,'%')]")).getText();
				 String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				 
				 //for testing purpose
//				 System.out.println(cpuValue);
//				 System.out.println(value);
				
				if (value.contains(cpuValue)) {
					System.out.println("CPU Load of Chrome is Equal");
				} else {
					System.out.println("CPU Load of Chrome is not equal");
				}
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}

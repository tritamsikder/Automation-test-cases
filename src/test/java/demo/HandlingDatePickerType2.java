package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDatePickerType2 {
	
	public void selectDate(WebDriver driver, String mon, String yr, String dt) {
		//selecting month
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month = new Select(monthDropdown);
		month.selectByContainsVisibleText(mon);
		//selecting year
		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByContainsVisibleText(yr);
		//Date selection
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for (WebElement date : dateList) {
			if (date.getText().equals(dt)) {
				date.click(); 
				break;
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//click on the date picker
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		HandlingDatePickerType2 dateSelect = new HandlingDatePickerType2();
		dateSelect.selectDate(driver, "Sep", "2022", "12");
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}

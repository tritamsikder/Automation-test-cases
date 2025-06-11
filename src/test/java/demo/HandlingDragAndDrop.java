package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandlingDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		//fetching the element xpath
		WebElement bank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement bankTarget = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		
		WebElement bankPrice = driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
		WebElement bankPriceTarget = driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
		
		WebElement sales = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement salesTarget = driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		
		WebElement salesPrice = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
		WebElement salesPriceTarget = driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		
		//creating Actions class object
		Actions act = new Actions(driver);
		
		//performing action
		act.dragAndDrop(bank, bankTarget).perform();
		act.dragAndDrop(bankPrice, bankPriceTarget).perform();
		
		//first building then performing action
		Action actSales = act.dragAndDrop(sales, salesTarget).build();
		Action actSalesPrice = act.dragAndDrop(salesPrice, salesPriceTarget).build();
		actSales.perform();
		actSalesPrice.perform();
		
		Thread.sleep(2000);
		driver.quit();	
	}

}

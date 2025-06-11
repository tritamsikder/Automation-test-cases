package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaticTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Total no of rows in a table
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println(noOfRows.size()); //single table
		
		List<WebElement> noOfAllRows = driver.findElements(By.tagName("tr"));
		System.out.println(noOfAllRows.size()); //multiple table
		
		//Total no of columns in a table
		List<WebElement> noOfColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println(noOfColumns.size()); //single table
		
		List<WebElement> noOfAllColumns = driver.findElements(By.tagName("th"));
		System.out.println(noOfAllColumns.size()); //multiple table
		
		//Read data from specific row and column
		System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]/td[3]")).getText());
		
		//Read data from all row and columns
		for(int r = 2; r <= noOfRows.size(); r++) {
		    for (int c = 1; c <= noOfColumns.size(); c++) {
		        String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
		        System.out.print(data + "\t"); // Print on the same line with a tab separator
		    }
		    System.out.println(); // Move to the next line after each row
		}
		
		//print all value from a specific column
		for(int r = 2; r <= noOfRows.size(); r++) {
			System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[3]")).getText());
		}
		
		//fetch table data based on value
		for(int r = 2; r <=noOfRows.size(); r++) {
			 String name = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			 {
				 if (name.equals("Amit")) {
					System.out.println(name + "\t" + driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText() 
							+ "\t" + driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[3]")).getText()
							+ "\t" + driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText());
				}
			 }
		}
		
		//total price of books
		int totalPrice = 0;
		for (int r = 2; r <= noOfRows.size(); r++) {
			int price = Integer.parseInt(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText());
			totalPrice += price;		
		}
		System.out.println(totalPrice);
		
		Thread.sleep(2000);
		driver.quit();
	}

}

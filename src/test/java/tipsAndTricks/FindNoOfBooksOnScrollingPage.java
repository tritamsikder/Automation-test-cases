package tipsAndTricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindNoOfBooksOnScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		
		//Failed
//		List<WebElement> allBooks = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
//		System.out.println("Total no of books: " + allBooks.size());
		
		//Failed
		//Using javaScript executor 	
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		List<WebElement> allBooks = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
//		System.out.println("Total no of books: " + allBooks.size());
		
		
		
		int currentCount = 0;
		int previousCount = 0;
		
		while(true) {
			List<WebElement> allBooks = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentCount = allBooks.size();
			
			if (currentCount == previousCount) {
				break;
			}
			previousCount = currentCount;
			
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			
			Thread.sleep(2000);
		}
		
		System.out.println("Total no of books: " + currentCount);
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}

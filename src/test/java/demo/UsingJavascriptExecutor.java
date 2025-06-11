package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingJavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rxpeptides.webgen.me/shop/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Handling date of birth pop up
		List<WebElement> popupInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[@class='age-gate__form-elements']/li/input")));
		popupInputs.get(0).sendKeys("12");
		popupInputs.get(1).sendKeys("12");
		popupInputs.get(2).sendKeys("1980");
		driver.findElement(By.xpath("//button[@name='ag_settings[submit]']")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='s']"));
		
		//Passing text into search box
		js.executeScript("arguments[0].setAttribute('value','Test')", searchBox);
		
		//Clicking on element
		WebElement seacrhBtn = driver.findElement(By.xpath("//div[@class='aws-search-btn aws-form-btn']"));
		js.executeScript("arguments[0].click()", seacrhBtn);
		
		//Scroll down page by pixel number	
		js.executeScript("window.scrollBy(0,1500)", ""); //"" -> (empty string) is not needed if you're not passing any WebElement arguments.
		Thread.sleep(2000);
		System.out.println(js.executeScript("return window.pageYOffset;")); 
		
		//Scroll to specific element and click
		Thread.sleep(2000); //Not required but used to see the actions
		WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='col-lg-8 col-md-8']//li[12]/a[normalize-space()='Add to cart']"));
		js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
		js.executeScript("arguments[0].click();", addToCartBtn);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//Scroll till end of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");    //We can use scrollTo() -> Scroll directly to the bottom.
																	  		  //scrollBy() -> scrolls relative to the current position, not absolute.
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//Scroll to initial position
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(4000);
		driver.quit();
	}

}

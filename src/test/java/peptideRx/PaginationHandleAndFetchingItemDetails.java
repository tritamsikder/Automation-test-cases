package peptideRx;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationHandleAndFetchingItemDetails {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://rxpeptides.webgen.me/shop/");
		driver.manage().window().maximize();
		
		//Handling date of birth pop up
		List<WebElement> popupInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[@class='age-gate__form-elements']/li/input")));
		popupInputs.get(0).sendKeys("12");
		popupInputs.get(1).sendKeys("12");
		popupInputs.get(2).sendKeys("1980");
		driver.findElement(By.xpath("//button[@name='ag_settings[submit]']")).click();
		
		//Total product count
		int totalProduct = 0;
		
		for (int p = 1; p <= 3; p++) {
			
		    if (p > 1) {
		        // Build XPath dynamically
		        String pageXPath = "//ul[@class='page-numbers']/li/a[normalize-space(text())='" + p + "']";

		        WebElement pageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pageXPath)));

		        // Scroll to the element to ensure it's in view
		        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageLink);
		        Thread.sleep(500); // small delay for any animation

		        // Use JS click to avoid interception
		        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", pageLink);

		        // Optional: wait for new page to load
		        Thread.sleep(2000);		        
		    }
		    
		    List<WebElement> titleList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='products columns-3']/li/a/h2")));
	
//			System.out.println(titleList.size());
			totalProduct += titleList.size();
			
			
			// Fetch price list
			List<WebElement> priceList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='products columns-3']//bdi")));

			// Print header
			System.out.printf("%-50s | %s%n", "Product Title", "Price");
			System.out.println("----------------------------------------------------|--------");
			
			//Fetch add to cart button
//			List<WebElement> addToCart = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='products columns-3']//a[@role='button']")));

			// Print title and price side by side
			for (int i = 0; i < titleList.size(); i++) {
			    String title = titleList.get(i).getText();
			    String price = (i < priceList.size()) ? priceList.get(i).getText() : "N/A";
			    System.out.printf("%-50s | %s%n", title, price);
			}

			
		}
		//Print total no of product
		System.out.println("Total no of products: " + totalProduct);
				
		Thread.sleep(2000);
		driver.quit();
	}

}

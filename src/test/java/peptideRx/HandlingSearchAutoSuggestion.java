package peptideRx;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingSearchAutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://rxpeptides.webgen.me");
		driver.manage().window().maximize();
		
		//Handling date of birth pop up
		List<WebElement> popupInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol[@class='age-gate__form-elements']/li/input")));
		popupInputs.get(0).sendKeys("12");
		popupInputs.get(1).sendKeys("12");
		popupInputs.get(2).sendKeys("1980");
		driver.findElement(By.xpath("//button[@name='ag_settings[submit]']")).click();
		
		//Fetching search box auto-suggest options
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']"))).sendKeys("te");
		Thread.sleep(2000);
		List<WebElement> searchItems = driver.findElements(By.xpath("//div[@id='aws-search-result-1']//li//a"));
		System.out.println(searchItems.size());
		for (WebElement item : searchItems) {
		    @SuppressWarnings("deprecation")
			String text = item.getAttribute("textContent").trim();
		    if (!text.isEmpty()) {
		        System.out.println(text);
		    }
		}
		
		//Fetching section titles
		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='elementor-widget-container']/h2"));
		System.out.println(titles.size());
		for (WebElement title : titles) {
			System.out.println(title.getText());
		}

		
		Thread.sleep(2000);
		driver.quit();
	}

}

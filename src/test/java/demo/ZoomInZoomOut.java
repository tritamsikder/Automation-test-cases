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

public class ZoomInZoomOut {

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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("document.body.style.zoom='50%'","");
		Thread.sleep(4000);
		
		js.executeScript("document.body.style.zoom='80%'");
		Thread.sleep(2000);
		
		js.executeScript("document.body.style.zoom='100%'");
		Thread.sleep(4000);		
		driver.quit();
	}

}

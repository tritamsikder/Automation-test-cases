package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement option = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select optn = new Select(option);
		
		List<WebElement> options = optn.getOptions();
		
		System.out.println(options.size());
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
//		optn.selectByValue("India");
//		optn.selectByIndex(2);
		optn.selectByVisibleText("France");
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}

package latclub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://latclubdevapi.webgen.me/admin/dashboard");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@dev.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[.='Log In']")).click();
		driver.findElement(By.xpath("//span[.='User Management']")).click();
		driver.findElement(By.xpath("//input[@id='from_date']")).click();
		
		Thread.sleep(2000);
		
		WebElement month = driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']"));  //Has xpath issue
		
		Select monthDropdown = new Select(month);
//		System.out.println(monthDropdown.getOptions());
		monthDropdown.selectByValue("7");
		WebElement year = driver.findElement(By.xpath("//div[@class='numInputWrapper']/input"));
		year.click();
		year.clear();
		year.sendKeys("2018");
		
		if (driver.findElement(By.xpath("//div[@class='dayContainer']//span")).isDisplayed()) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		List<WebElement> date = driver.findElements(By.xpath("//div[@class='dayContainer']//span"));
		for (WebElement dt : date) {
			if (dt.getText().equals("20")) {
				dt.click();
				break;             
			}
		}
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}

package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MinimizeMaximize {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rxpeptides.webgen.me/shop/");
		
		Thread.sleep(2000);
		//Minimize window
		driver.manage().window().minimize();
		
		Thread.sleep(2000);
		//Maximize window
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.close();
		
	}

}

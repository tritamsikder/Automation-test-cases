package hmcTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://fishdiseaseidentifier.webgen.me/");
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		if(pageTitle.equals("fishdiseaseidentifier.webgen.me")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

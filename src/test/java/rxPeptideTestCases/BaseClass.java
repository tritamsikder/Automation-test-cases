package rxPeptideTestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

public class BaseClass {
	WebDriver driver;
	 @BeforeClass
	    public void beforeClass() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://rxpeptides.webgen.me/");

	        driver.findElement(By.xpath("//input[@id='age-gate-m']")).sendKeys("12");
	        driver.findElement(By.xpath("//input[@id='age-gate-d']")).sendKeys("12");
	        driver.findElement(By.xpath("//input[@id='age-gate-y']")).sendKeys("1980");
	        driver.findElement(By.xpath("//button[@name='ag_settings[submit]']")).click();
	    }

	    @AfterClass
	    public void afterClass() throws InterruptedException {
	        Thread.sleep(2000);
	        driver.quit();
	    }
	    
	    public String randomEmail() {
	    	Random random = new Random();
	        int randomInt = random.nextInt(10000);
	        String email = "test" + randomInt + "@mail.com";
	        return email;
	    }
}

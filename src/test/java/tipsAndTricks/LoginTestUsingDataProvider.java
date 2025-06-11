package tipsAndTricks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestUsingDataProvider {
  @Test (dataProvider = "loginData")
  public void loginTest(String email, String password) throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://demowebshop.tricentis.com/login");
	  
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='Log in']")).click();
	  
	  boolean loginStatus;
	  
	  try {
		  loginStatus = driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed();
		  Assert.assertTrue(loginStatus);	
	} catch (Exception e) {
		loginStatus = false;
		Assert.assertTrue(loginStatus);
	} finally {
		Thread.sleep(2000);
		driver.quit();
	}
  }
  
  @DataProvider (parallel = true, indices = {0,1})
  public String[][] loginData() {
	  String[][] data = {
			  {"test","test"},
			  {"test5555@test.com","Test@123"},
			  {"test","test"},
			  {"test","test"},
			  {"test5555@test.com","Test@123"}
	  };
	  return data;
  }
}

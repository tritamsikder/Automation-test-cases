package threadSafetyConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NewTest1 {
	
	WebDriver driver;
  @Test
  public void test1() {
	  driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  System.out.println(driver.getTitle());
	  driver.quit();
  }
  
  @Test
  public void test2() {
	  driver = new EdgeDriver();
	  driver.get("https://www.bing.com/");
	  System.out.println(driver.getTitle());
	  driver.quit();
  }
}

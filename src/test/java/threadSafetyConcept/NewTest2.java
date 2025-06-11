package threadSafetyConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class NewTest2 {
	
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		tdriver.set(driver);
	}
	
	public WebDriver getDriver() {
		return tdriver.get();
	}
	
  @Test
  public void test1() {
	  driver = new ChromeDriver();
	  setDriver(driver);
	  getDriver().get("https://www.google.com/");
	  System.out.println(getDriver().getTitle());
	  getDriver().quit();
  }
  
  @Test
  public void test2() {
	  driver = new EdgeDriver();
	  setDriver(driver);
	  getDriver().get("https://www.bing.com/");
	  System.out.println(getDriver().getTitle());
	  getDriver().quit();
  }
  
  @AfterClass
  void tearDown() {
	  tdriver.remove();
  }
}

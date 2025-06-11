package newTestNGTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	
	
  @BeforeClass 
  public void beforeClass() {
	  System.out.println("This is before class method...");
  }
  
  @AfterClass 
  public void afterClass() {
	  System.out.println("This is after class method...");
  }
	
  @BeforeMethod
  public void openApp() {
	  System.out.println("Open app.......");
  }
  
  @AfterMethod
  public void closeApp() {
	  System.out.println("Close app........");
  }

  @Test (priority = 2)
  public void login() {
	  System.out.println("Login.........");
  }
  
  @Test (priority = 1)
  public void checkLogo() {
	  System.out.println("Check logo...");
  }
  
  
  
  
}

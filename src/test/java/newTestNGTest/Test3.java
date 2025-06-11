package newTestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test3 {
  @Test
  public void f() {
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite method....");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite method....");
  }
  

}

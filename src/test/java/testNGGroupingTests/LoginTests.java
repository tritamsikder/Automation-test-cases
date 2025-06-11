package testNGGroupingTests;

import org.testng.annotations.Test;

public class LoginTests {
  @Test (priority = 1, groups = "smoke")
  public void loginByEmail() {
	  System.out.println("Logging in by email");
  }
  
  @Test (priority = 2, groups = "smoke")
  public void loginByFacebook() {
	  System.out.println("Logging in by facebook");
  }
  
  @Test (priority = 3, groups = "smoke")
  public void loginByInstagram() {
	  System.out.println("Logging in by instagram");
  }
  
}

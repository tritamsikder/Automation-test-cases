package testNGGroupingTests;

import org.testng.annotations.Test;

public class signUpTests {
	  @Test (priority = 1, groups = "regression")
	  public void signupByEmail() {
		  System.out.println("signin in by email");
	  }
	  
	  @Test (priority = 2, groups = "regression")
	  public void signupByFacebook() {
		  System.out.println("signin in by facebook");
	  }
	  
	  @Test (priority = 3, groups = "regression")
	  public void signupByInstagram() {
		  System.out.println("signin in by instagram");
	  }
}

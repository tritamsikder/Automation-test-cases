package newTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
  @Test
  public void f() {
	  String expectedTitle = "abc";
	  String actualTitle = "abc";
	  
//	  if (expectedTitle.equals(actualTitle)) {
//		System.out.println("Test Pass");
//	} else {
//		System.out.println("Test Fail");
//	}
	  
	  Assert.assertEquals(expectedTitle, actualTitle);
	  
	  if (expectedTitle.equals(actualTitle)) {
		  System.out.println("Test Passed");
		  Assert.assertTrue(true);	
	} else {
		System.out.println("Test Failed");
		Assert.assertTrue(false);
	}
  }
}

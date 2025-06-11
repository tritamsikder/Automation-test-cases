package newTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVSSoftAssertions {
	
	SoftAssert sa = new SoftAssert();
	
  @Test
//  public void testHardAssertions() {
//	  System.out.println("Test1........");
//	  System.out.println("Test2........");
//	  Assert.assertEquals(2, 1);
//	  System.out.println("Test3........");
//	  System.out.println("Test4........");
//  }
  
  public void testSoftAssertions() {
	  System.out.println("Test1........");
	  System.out.println("Test2........");
	  
//	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(2, 1);
	  
	  System.out.println("Test3........");
	  System.out.println("Test4........");
	  
	  sa.assertAll();
  }
}

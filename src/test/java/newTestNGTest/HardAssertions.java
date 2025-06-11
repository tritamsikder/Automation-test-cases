package newTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
  @Test
  public void test1() {
//	  Assert.assertEquals("xyz", "xyz");
  
//	  Assert.assertEquals(123, 345);
//  
//	  Assert.assertEquals("abc", 123);
//  
//	  Assert.assertEquals("123", 123);
//   
//	  Assert.assertNotEquals(123, 123);
//    
//	  Assert.assertNotEquals(123, 345);
//  
//	  Assert.assertTrue(true);
//  
//	  Assert.assertTrue(false);
//  
//	  Assert.assertTrue(1 == 1);
// 
//	  Assert.assertTrue(1 == 2);
// 
//	  Assert.assertFalse(1 == 1);
//
	  Assert.assertFalse(1 == 2);
	  
	  Assert.fail();
}
}

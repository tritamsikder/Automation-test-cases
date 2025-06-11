package testNGGroupingTests;

import org.testng.annotations.Test;

public class paymentMethods {
  @Test (priority = 1, groups = {"smoke", "regression", "functional"})
  public void paymentInCash() {
	  System.out.println("Payment done in cash");
  }
  
  @Test (priority = 2, groups = {"smoke","regression", "functional"})
  public void paymentInCard() {
	  System.out.println("Payment done in card");
  }
}

package testNG;

import org.testng.annotations.Test;

//open Application
//login
//logout

public class TestCase1 {
	
	@Test (priority = 1)
	void openApp() {
		System.out.println("Opening App.............");
	}
	
	@Test (priority = 2)
	void login() {
		System.out.println("Login to App...........");
	}
	
	@Test (priority = 3)
	void logout() {
		System.out.println("Logout from App............");
	}
}

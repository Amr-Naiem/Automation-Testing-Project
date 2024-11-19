package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginHappyScenario extends BaseTest{
	HomePage homeObject;
	LoginPage loginObject; 
	RegisterPage registerObject;
	
	public void initializeObjects() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerObject = new RegisterPage(driver);
	}
  @Test (priority = 1)
  public void Login_CorrectUsernameAndCorrectPassword() throws InterruptedException {
	 
	  // Step 1: Initialize page objects for the test
	  initializeObjects();
	  
	  // Step 2: Navigate to the registration/login page
	  homeObject.goToRegisterationPage();;
	  Thread.sleep(2000);
	  
	  // Step 3: Verify that the login page is displayed with the correct message
	  Assert.assertEquals(loginObject.loginMessage.getText(), "Login to your account");
	  
	  // Step 4: Log in using valid credentials
	  loginObject.userCanLogin("amr@gmail.com", "amr");
	  Thread.sleep(2000);
	  
	  // Step 5: Verify successful login by checking the 'Logged in as' message
	  Assert.assertTrue(loginObject.loginSuccessIndecator.getText().contains("Logged in as "));
	  Thread.sleep(2000);
	  
	 
  }
  

}

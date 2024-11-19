package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class Login_NegativeScenario extends BaseTest{
	HomePage homeObject;
	LoginPage loginObject; 
	RegisterPage registerObject;
	
	
	// Initialize page objects before the test
	public void initializeObjects() 
	{
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerObject = new RegisterPage(driver);
	}
  
  @Test(priority = 2)
  public void Login_InCorrectUsernameAndPassword() throws InterruptedException 
  {
	  // Step 1: Initialize page objects for the test
	  initializeObjects();
	  
	  // Step 2: Navigate to the registration/login page
	  homeObject.goToRegisterationPage();
	  Thread.sleep(2000);
	  
	  // Step 3: Verify the login message is displayed
	  Assert.assertEquals(loginObject.loginMessage.getText(), "Login to your account");
	  
	  // Step 4: Attempt login with incorrect username and password	  	
	  loginObject.userCanLogin("amr@gmail.com", "amr12");
	  Thread.sleep(2000);
	  
	  // Step 5: Verify the error message for incorrect login credentials
	  Assert.assertEquals(loginObject.failedMessage.getText(), "Your email or password is incorrect!");  
	  
  }
}

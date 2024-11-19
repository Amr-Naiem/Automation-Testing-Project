package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {
 
	LoginPage LoginPage;
	HomePage homePage;
	LoginPage loginPage;
	LogoutPage logoutPage;
	
	
	public void initializeObjects() 
	{
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		logoutPage=new LogoutPage(driver);
	}
	
	@Test
  public void tsetLogout() throws InterruptedException 
  {
		// Step 1: Initialize page objects
		initializeObjects();
		
		// Step 2: Navigate to the registration/login page
		homePage.goToRegisterationPage();
		
		// Step 3: Verify that the login page is displayed with the correct message
		Assert.assertEquals(loginPage.loginMessage.getText(), "Login to your account");
		Thread.sleep(1500);
		
		// Step 4: Log in using valid credentials
		loginPage.userCanLogin("amr@gmail.com","amr");
		Thread.sleep(1500);
		
		// Step 5: Perform the logout action
		logoutPage.clickLogOut();
		Thread.sleep(1500);
	    
		// Step 6: Verify the user has been logged out successfully
		Assert.assertFalse(loginPage.loginSuccessIndecator.getText().contains("Logged in as "));
		Thread.sleep(3500);
  }
		
}

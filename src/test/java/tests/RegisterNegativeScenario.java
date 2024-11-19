package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterNegativeScenario extends BaseTest {
  

	HomePage homePage;
	RegisterPage registerPage;
	
	
  
	public void intializeObjects() 
	{
		 homePage = new HomePage(driver);
		 registerPage = new RegisterPage(driver);	
	}
	
  @Test(priority = 2)
  public void userRegisterationExistEmail() throws InterruptedException 
  {
	  intializeObjects();  // Step 1: Initialize necessary page objects
	  
	  // Step 2: Navigate to the registration page
	  homePage.goToRegisterationPage();
	  //Thread.sleep(3000);
	  
	  // Step 3: Try to register with an already existing email
	  registerPage.newUserSignUp("Omar","omar@yahoo.com");
	  
	  // Step 4: Verify that the correct error message is displayed
	  Assert.assertEquals(registerPage.failedMessage.getText(),"Email Address already exist!");
  }
  
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterHappyScenario extends BaseTest {
  

	HomePage homePage;
	RegisterPage registerPage;
	
	
  
	public void intializeObjects() 
	{
		 homePage = new HomePage(driver);
		 registerPage = new RegisterPage(driver);	
	}
	
	
  @Test(priority = 1)
  public void testUserRegisteration() throws InterruptedException 
  {  
	  intializeObjects();  // Step 1: Initialize the necessary page objects
	  
	  // Step 2: Navigate to the registration page
	  homePage.goToRegisterationPage();
	  //Thread.sleep(3000);
	  
	  // Step 3: Verify 'New User Signup!' message is visible
	  Assert.assertEquals(registerPage.newUserSignUpMessage.getText(),"New User Signup!");
	  
	  // Step 4: Fill in the registration form with user details
	  registerPage.newUserSignUp("Omar", "omar1001@yahoo");
	  //Thread.sleep(3000);
	  
	  // Step 5: Verify the 'Enter Account Information' message is displayed
	  Assert.assertEquals(registerPage.EnterAccountInformationMessage.getText(),"Enter Account Information".toUpperCase());
	  
	  // Step 6: Complete the account registration form
	  registerPage.userRegisterationForm("MyPassword","13","12","2012","Omar","Z","Australia","Barq","7th Of October","Giza","Cairo","Cairo","123","011223344");
	  //Thread.sleep(3000);
	  
	  // Step 7: Verify that the account is successfully created
	  Assert.assertEquals(registerPage.successMessage.getText(),"ACCOUNT CREATED!");
	  //Thread.sleep(3000);
	  
	  // Step 8: Click 'Continue' after account creation
	  registerPage.continueAccount();
	  //Assert.assertTrue(registerPage.navBarList.get(9).getText().contains("Logged in as") );
	  
	  // Step 9: Verify the user is logged in
	  Assert.assertTrue(registerPage.continueSuccessIndecator.getText().contains("Logged in as "));
	  //Thread.sleep(3000);
	  
	  // Step 10: Delete the account after registration
	  registerPage.deleteAccount();
	  
	  // Step 11: Verify 'Account Deleted!' message is displayed
	  Assert.assertTrue(registerPage.deleteAccountMessage.getText().contains("Account Deleted".toUpperCase()));
	  //Thread.sleep(3000);
  }
  
  
}

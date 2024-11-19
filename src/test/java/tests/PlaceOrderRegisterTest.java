package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class PlaceOrderRegisterTest extends BaseTest {

    HomePage homePage;
    OrderPage orderPage;
    CartPage cartPage;
    ProductsPage productsPage;
    RegisterPage registerPage;
    
    @Test
    public void testPlaceOrderRegisterWhileCheckout() throws InterruptedException {
    	// Step 1: Initialize page objects
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        cartPage = new CartPage(driver);
        productsPage= new ProductsPage(driver);
        registerPage =new RegisterPage(driver);

        // Step 2: Verify that the home page is visible
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click on the 'Products' button
        productsPage.clickProductsBtn();
        
        Thread.sleep(2000);
        // Step 4: Scroll down the page slightly to bring products into view
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 350);");

        // Step 5: Add the first product to the cart
        productsPage.clickAddToCart(0); // Add first product to cart
        Thread.sleep(2000);
        
        // Step 6: Continue shopping after adding the first product
        productsPage.clickContinueShopping();
        Thread.sleep(2000);
       
        // Step 7: Click on the 'View Cart' button to view the cart
        productsPage.clickViewCart();
        Thread.sleep(2000);
        
        // Step 8: Proceed to the checkout page
        orderPage.clickProceedToCheckout();
        Thread.sleep(2000);
        
        // Step 9: Click on 'Register or Login' to start the registration process
        orderPage.clickRegisterOrLogin();
        Thread.sleep(2000);
        
        // Step 10: Verify the 'New User Signup!' message is displayed and begin registration
        Assert.assertEquals(registerPage.newUserSignUpMessage.getText(),"New User Signup!");
  	  	registerPage.newUserSignUp("Omar", "omar211@yahoo");
  	  	Thread.sleep(3000);
  	  	
  	  	// Step 11: Verify the 'Enter Account Information' message and complete the registration form
  	  	Assert.assertEquals(registerPage.EnterAccountInformationMessage.getText(),"Enter Account Information".toUpperCase());
  	  	registerPage.userRegisterationForm("MyPassword","13","12","2012","Omar","Z","Australia","Barq","7th Of October","Giza","Cairo","Cairo","123","011223344");
  	  	Thread.sleep(3000);
  	  	
  	  	// Step 12: Verify that the account was created successfully
  	  	Assert.assertEquals(registerPage.successMessage.getText(),"ACCOUNT CREATED!");
  	  	Thread.sleep(3000);
  	  	
  	  	// Step 13: Click 'Continue' after account creation and verify login success
  	  	registerPage.continueAccount();
  	  	Assert.assertTrue(registerPage.continueSuccessIndecator.getText().contains("Logged in as "));
  	  	Thread.sleep(3000);
  	  	
  	  	// Step 14: View the cart again after registration
  	  	productsPage.clickViewCart();
  	  	
  	  	// Step 15: Proceed to checkout once more
        orderPage.clickProceedToCheckout();
        Thread.sleep(2000);
        
        // Step 16: Enter a comment for the order
        orderPage.enterComment("Elbday3a Tmam");
        
        /*Add Payment Details*/
        // Step 17: Add payment details and confirm the order
        orderPage.enterPaymentDetails("Omar Yousef Ahmed","5594444455","222","12","2020");
        Thread.sleep(2000);
        orderPage.clickPayAndConfirmOrder();
        //Thread.sleep(2000);
        
        //Assert.assertTrue(orderPage.isOrderSuccessMessageVisible(), "Order success message is not visible");
        Thread.sleep(2000);

        // Step 18: Delete the account after placing the order
        orderPage.clickDeleteAccount();

        // Step 19: Verify that the 'ACCOUNT DELETED!' message is visible and click 'Continue'
        Assert.assertTrue(orderPage.isAccountDeletedMessageVisible(),"'ACCOUNT DELETED!' message is not visible");
        /*Go to home page*/
        orderPage.clickContinueBtn();
    }
}

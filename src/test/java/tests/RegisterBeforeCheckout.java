package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class RegisterBeforeCheckout extends BaseTest {

    HomePage homePage;
    OrderPage orderPage;
    CartPage cartPage;
    ProductsPage productsPage;
    RegisterPage registerPage;
    
    @Test
    public void testPlaceOrderRegisterWhileCheckout() throws InterruptedException {
    	// Step 1: Initialize the page objects
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        cartPage = new CartPage(driver);
        productsPage= new ProductsPage(driver);
        registerPage =new RegisterPage(driver);

        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");
        // Step 3: Navigate to the registration page
        homePage.goToRegisterationPage();
        // Step 4: Verify 'New User Signup!' message is visible	  
        Assert.assertEquals(registerPage.newUserSignUpMessage.getText(),"New User Signup!");
        // Step 5: Fill in the signup form with user details
        registerPage.newUserSignUp("Omar", "omar2122@yahoo");
        // Step 6: Verify the 'Enter Account Information' message is displayed
	    Assert.assertEquals(registerPage.EnterAccountInformationMessage.getText(),"Enter Account Information".toUpperCase());
	    // Step 7: Complete the account registration form
	    registerPage.userRegisterationForm("MyPassword","13","12","2012","Omar","Z","Australia","Barq","7th Of October","Giza","Cairo","Cairo","123","011223344");
	    // Step 8: Verify account creation success message
	    Assert.assertEquals(registerPage.successMessage.getText(),"ACCOUNT CREATED!");
	    // Step 9: Click 'Continue' to proceed after account creation
	    registerPage.continueAccount();
	    // Step 10: Verify the user is logged in after account creation
	    Assert.assertTrue(registerPage.continueSuccessIndecator.getText().contains("Logged in as "));
	  
        
	    // Step 11: Click on the 'Products' button to navigate to the products page
        productsPage.clickProductsBtn();
        
        // Step 12: Scroll down by a value of 350
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 350);");

        // Step 13: Hover over the first product and add it to the cart
        productsPage.clickAddToCart(0); // Add first product to cart
        Thread.sleep(2000);
        
        // Step 14: Click 'Continue Shopping' after adding product to cart
        productsPage.clickContinueShopping();
        Thread.sleep(2000);
        // Step 15: Click 'View Cart' to go to the cart page
        productsPage.clickViewCart();
        Thread.sleep(2000);
        // Step 16: Proceed to checkout
        orderPage.clickProceedToCheckout();
        Thread.sleep(2000);
        // Step 17: Enter a comment about the order
        orderPage.enterComment("Elbday3a Gamda");
        /*Add Payment Details*/
        // Step 18: Add payment details
        orderPage.enterPaymentDetails("Omar Yousef Ahmed","5594444455","222","12","2020");
        Thread.sleep(2000);
        // Step 19: Click 'Pay and Confirm Order'
        orderPage.clickPayAndConfirmOrder();
        
        //Assert.assertTrue(orderPage.isOrderSuccessMessageVisible(), "Order success message is not visible");
        Thread.sleep(2000);

        // Step 20: Click 'Delete Account' after the order is placed
        orderPage.clickDeleteAccount();

        // Step 21: Verify 'ACCOUNT DELETED!' message is displayed and click 'Continue'
        Assert.assertTrue(orderPage.isAccountDeletedMessageVisible(),"'ACCOUNT DELETED!' message is not visible");
        // Step 22: Return to the home page
        orderPage.clickContinueBtn();
    }
}

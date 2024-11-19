package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class LoginBeforeCheckout extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    OrderPage orderPage;
    CartPage cartPage;
    ProductsPage productsPage;
    RegisterPage registerPage;
    
    // Initialize all page objects before running the test
    public void initializeObjects() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
        orderPage = new OrderPage(driver);
        cartPage = new CartPage(driver);
        productsPage= new ProductsPage(driver);
	}
    
    @Test
    public void testPlaceOrderRegisterWhileCheckout() throws InterruptedException {

    	initializeObjects();

    	// Step 1: Navigate to the registration/login page
    	/*lOGIN */
    	homePage.goToRegisterationPage();;
    	Thread.sleep(2000);
    	
    	// Step 2: Verify login page is displayed with the correct message
   	  	Assert.assertEquals(loginPage.loginMessage.getText(), "Login to your account");
   	  	
   	  	// Step 3: Perform login with valid credentials
   	  	loginPage.userCanLogin("amr@gmail.com", "amr");
   	  	Thread.sleep(2000);
   	  	
   	  	// Step 4: Verify successful login by checking 'Logged in as' message
   	  	Assert.assertTrue(loginPage.loginSuccessIndecator.getText().contains("Logged in as "));

        
        // Step 5: Click on 'Products' button to view available products
        productsPage.clickProductsBtn();
        
        Thread.sleep(2000);
        
        // Step 6: Scroll down slightly to make products visible
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 350);");

        // Step 7: Add the first product to the cart
        productsPage.clickAddToCart(0); // Add first product to cart
        Thread.sleep(2000);
        
        // Step 8: Click 'Continue Shopping' to continue browsing products
        productsPage.clickContinueShopping();
        Thread.sleep(2000);
        
        // Step 9: View the cart
        productsPage.clickViewCart();
        Thread.sleep(2000);
        
        // Step 10: Proceed to checkout
        orderPage.clickProceedToCheckout();
        Thread.sleep(2000);
        
        // Step 11: Add a comment in the order comment section
        orderPage.enterComment("Elbday3a Gamda");
        
        // Step 12: Enter payment details (replace with valid details)
        /*Add Payment Details*/
        orderPage.enterPaymentDetails("Omar Yousef Ahmed","5594444455","222","12","2020");
        Thread.sleep(2000);
        
        // Step 13: Click 'Pay and Confirm Order' to finalize the purchase
        orderPage.clickPayAndConfirmOrder();
        //Thread.sleep(2000);
        
        //Assert.assertTrue(orderPage.isOrderSuccessMessageVisible(), "Order success message is not visible");
        Thread.sleep(2000);

        // Step 14: Verify the account deletion message is displayed
        Assert.assertTrue(orderPage.isAccountDeletedMessageVisible(),"'ACCOUNT DELETED!' message is not visible");
        /*Go to home page*/
        orderPage.clickContinueBtn();
    }
}

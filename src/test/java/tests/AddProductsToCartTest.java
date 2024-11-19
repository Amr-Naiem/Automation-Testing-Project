package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class AddProductsToCartTest extends BaseTest {

    ProductsPage productsPage;

    @Test
    public void testAddProductsToCart() throws InterruptedException {
        productsPage = new ProductsPage(driver);

        // Step 1: Verify the home page is displayed successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 2: Click on the 'Products' button to view the products page
        productsPage.clickProductsBtn();

        Thread.sleep(2000);
        
        
        // Step 3: Wait for the page to load and scroll down slightly
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 350);");

        
        // Step 4: Add the first product to the cart
        productsPage.clickAddToCart(0); // Add first product to cart
        Thread.sleep(2000);
        
        // Step 5: Click 'Continue Shopping' to add another product
        productsPage.clickContinueShopping();
        Thread.sleep(2000);
        
        // Step 6: Add the second product to the cart
        productsPage.clickAddToCart(1); // Add second product to cart
        Thread.sleep(2000);
        
        // Step 7: Click 'Continue Shopping' again
        productsPage.clickContinueShopping();
        
        // Step 8: Click 'View Cart' to check the cart contents
        productsPage.clickViewCart();
        Thread.sleep(2000);
        
        // Step 9: Verify that both products are successfully added to the cart
        Assert.assertTrue(productsPage.areProductsInCart(), "Both products are not in the cart");
        Thread.sleep(2000);
        // Optional: Additional checks for prices, quantities, and total price can be added here.
    }
}
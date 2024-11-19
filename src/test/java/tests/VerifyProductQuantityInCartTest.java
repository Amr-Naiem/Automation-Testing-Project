package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ProductDetailPage;

public class VerifyProductQuantityInCartTest extends BaseTest {

    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    @Test
    public void testVerifyProductQuantityInCart() throws InterruptedException {
    	// Step 1: Initialize the ProductsPage and ProductDetailPage objects
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click 'View Product' for the first product on the home page
        productsPage.clickFirstProduct(); // Assuming the first product is clicked

        // Step 4: Verify that the product detail page is opened
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page is not visible");

        // Step 5: Increase quantity to 4
        productDetailPage.setQuantity("4");

        // Step 6: Click 'Add to cart' button
        productDetailPage.clickAddToCart();

        // Adding a wait to ensure the operation completes
        Thread.sleep(2000);
        // Step 7: Click 'Continue Shopping' button
        productDetailPage.clickContinueShopping();
        
        // Step 8: Click 'View Cart' button
        productDetailPage.clickViewCart();

        // Step 9: Verify that the product is displayed in the cart with the correct quantity
        Assert.assertEquals(productDetailPage.getCartProductQuantity(), "4", "Product quantity in cart is incorrect");
    }
}

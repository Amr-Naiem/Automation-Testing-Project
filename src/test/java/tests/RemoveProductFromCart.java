package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ProductDetailPage;

public class RemoveProductFromCart extends BaseTest {

    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    @Test
    public void testVerifyProductQuantityInCart() throws InterruptedException {
    	// Step 1: Initialize page objects for products and product details
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        // Step 2: Verify that home page title contains "Automation Exercise" to confirm visibility
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click 'View Product' for any product on the home page
        productsPage.clickFirstProduct(); // Assuming the first product is clicked

        // Step 4: Verify product detail is opened
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail page is not visible");

        // Step 5: Increase quantity to 4
        productDetailPage.setQuantity("4");

        // Step 6: Click 'Add to cart' button
        productDetailPage.clickAddToCart();
        
        // Step 7: Pause for 2 seconds to wait for the cart action to complete
        Thread.sleep(2000);
        
        // Step 8: Continue shopping after adding the product to the cart
        productDetailPage.clickContinueShopping();
        
        // Step 9: Click 'View Cart' button to Navigate to the cart page to view the products in the cart
        productDetailPage.clickViewCart();
        
        // Step 10: Delete the product from the cart
        productDetailPage.deleteProductFromCart();
        
    }
}

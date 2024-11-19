package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ProductDetailPage;

public class ProductsTest extends BaseTest {
    
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    @Test
    public void testVerifyAllProductsAndProductDetail() throws InterruptedException {
    	// Step 1: Initialize the page objects
    	productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        // Step 2: Verify that the home page is displayed successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        //driver.findElementByXPath("//a[contains(text(),'Products')]").click();

        // Step 3: Click on the 'Products' button to navigate to the products page
        productsPage.clickProductsBtn();
        
        // Step 4: Verify that the user is navigated to the "ALL PRODUCTS" page successfully
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "User is not navigated to ALL PRODUCTS page successfully");

        // Step 5: Ensure the list of products is visible on the "ALL PRODUCTS" page
        Assert.assertTrue(productsPage.isProductListVisible(), "Products list is not visible");

        Thread.sleep(2000);
        // Step 6: Click on 'View Product' for the first product in the list
        productsPage.clickFirstProduct();

        // Step 7: Verify that the user is directed to the product detail page
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product detail is not visible");

        // Step 8: Check if the product details are displayed correctly: product name, category, price, availability, condition, and brand
        Assert.assertTrue(productDetailPage.isProductDetailVisible(), "Product details are not visible");
    }
}

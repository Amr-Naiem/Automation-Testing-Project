package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class SearchProductTest extends BaseTest {

    ProductsPage productsPage;

    @Test
    public void testSearchProduct() {
        productsPage = new ProductsPage(driver); // Step 1: Initialize the ProductsPage object

        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click on the 'Products' button to navigate to the products page
        productsPage.clickProductsBtn();

        // Step 4: Verify the user is navigated to the ALL PRODUCTS page successfully
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "User is not navigated to ALL PRODUCTS page successfully");

        // Step 5: Enter the product name "T-Shirt" in the search input and click the search button
        productsPage.searchProduct("T-Shirt");

        // Step 6: Verify that the 'SEARCHED PRODUCTS' section is visible
        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' is not visible");

        // Step 7: Verify that all products related to the search term are visible
        Assert.assertTrue(productsPage.areSearchResultsVisible(), "No products related to search are visible");
       
    }
}

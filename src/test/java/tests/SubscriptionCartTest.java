package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FooterPage;

public class SubscriptionCartTest extends BaseTest {

    CartPage cartPage;
    FooterPage footerPage;

    @Test
    public void testVerifySubscriptionInCart() {
    	// Step 1: Initialize the CartPage and FooterPage objects
        cartPage = new CartPage(driver);
        footerPage = new FooterPage(driver);

        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click the 'Cart' button to navigate to the cart page
        cartPage.clickCartButton();

        // Step 4: Scroll down to the footer section
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Step 5: Verify that the 'SUBSCRIPTION' header is visible
        Assert.assertTrue(footerPage.isSubscriptionHeaderVisible(), "'SUBSCRIPTION' header is not visible");

        // Step 6: Enter an email address in the input field and click the arrow button to subscribe
        footerPage.enterEmailAndSubscribe("test@example.com");

        // Step 7: Verify the success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(footerPage.isSuccessMessageVisible(), "'You have been successfully subscribed!' message is not visible");
    }
}

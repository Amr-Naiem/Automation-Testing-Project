package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FooterPage;

public class SubscriptionTest extends BaseTest {

    FooterPage footerPage;

    @Test
    public void testVerifySubscription() {
    	
    	// Step 1: Initialize the FooterPage object
        footerPage = new FooterPage(driver);

        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Scroll down to the footer section
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Step 4: Verify that the 'SUBSCRIPTION' header is visible
        Assert.assertTrue(footerPage.isSubscriptionHeaderVisible(), "'SUBSCRIPTION' header is not visible");

        // Step 5: Enter an email address in the input field and click the arrow button to subscribe
        footerPage.enterEmailAndSubscribe("test@example.com");

        // Step 6: Verify the success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(footerPage.isSuccessMessageVisible(), "'You have been successfully subscribed!' message is not visible");
    }
}

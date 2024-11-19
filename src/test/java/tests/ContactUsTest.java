package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {
    
    ContactUsPage contactUsPage;


    @Test
    public void testContactUsForm() throws InterruptedException {
    	
    	contactUsPage=new ContactUsPage(driver);
    	
        // Step 1: Verify the home page is displayed successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 2: Click the 'Contact Us' button to navigate to the contact form
        contactUsPage.clickContactUs();

        // Step 3: Verify that the 'GET IN TOUCH' section is visible
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible");

        // Step 4: Fill out the contact form with name, email, subject, and message
        contactUsPage.fillContactForm("Omar", "omar@example.com", "Test Subject", "This is a test message.");

        // Step 5: (Optional) Upload a file if needed (provide a valid file path in your system)
        //contactUsPage.uploadFile("path/to/file.txt");

        // Step 6: Click the 'Submit' button to send the contact form
        Thread.sleep(3000);
        contactUsPage.clickSubmit();
        
        Thread.sleep(3000);

        // Step 7: Handle the alert popup and accept it (click OK)
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Step 8: Verify the success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(contactUsPage.successMessage.getText().contains("Success"));

        // Step 9: Click the 'Home' button and verify that the user returns to the home page
        contactUsPage.clickHome();
        String newHomePageTitle = driver.getTitle();
        Assert.assertTrue(newHomePageTitle.contains("Automation Exercise"), "Failed to return to the home page");
    }

}

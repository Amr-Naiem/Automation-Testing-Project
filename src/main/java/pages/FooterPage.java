package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
    public FooterPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    WebElement subscriptionHeader; // Private for encapsulation

    @FindBy(id = "susbscribe_email")
    WebElement emailInput; // Private for encapsulation

    @FindBy(id = "subscribe")
    WebElement subscribeButton; // Private for encapsulation

    @FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    WebElement successMessage; // Private for encapsulation

    // Page Methods (Actions)
    // Checks if the 'Subscription' header is visible in the footer.
    public boolean isSubscriptionHeaderVisible() {
        return subscriptionHeader.isDisplayed(); // @return true if the subscription header is visible, false otherwise.
    }

    // Enters the provided email into the subscription input and clicks the subscribe button.
    public void enterEmailAndSubscribe(String email) {
        emailInput.sendKeys(email); // @param email The email address to subscribe with.
        subscribeButton.click();
    }
    
    // Checks if the success message is visible after form submission.
    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed(); // @return true if the success message is visible, false otherwise.
    }
}

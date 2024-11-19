package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    WebElement contactUsButton; // Private for encapsulation

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElement getInTouchHeader; // Private for encapsulation

    @FindBy(name = "name")
    WebElement nameInput; // Private for encapsulation

    @FindBy(name = "email")
    WebElement emailInput; // Private for encapsulation

    @FindBy(name = "subject")
    WebElement subjectInput; // Private for encapsulation

    @FindBy(id = "message")
    WebElement messageInput; // Private for encapsulation

    @FindBy(name = "upload_file")
    WebElement uploadFileInput; // Private for encapsulation

    @FindBy(name = "submit")
    WebElement submitButton; // Private for encapsulation

    @FindBy(xpath = "//div[contains(text(),'Success! Your details have been submitted successfully.')]")
    public WebElement successMessage; // Public access for verification purposes
    
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement homeButton; // Private for encapsulation

    // Page Methods (Actions)
    public void clickContactUs() {
        contactUsButton.click(); // Clicks the 'Contact Us' button to navigate to the contact form.
    }

    public boolean isGetInTouchVisible() {
        return getInTouchHeader.isDisplayed(); // Checks if the 'Get In Touch' header is visible on the page.
    }

    // Fills out the contact form with the provided details.
    public void fillContactForm(String name, String email, String subject, String message) {
        nameInput.sendKeys(name); // @param name    The name of the person contacting.
        emailInput.sendKeys(email); // @param email   The email address of the person contacting.
        subjectInput.sendKeys(subject); // @param subject The subject of the message.
        messageInput.sendKeys(message); // @param message The message content.
    }
    
    // Uploads a file using the provided file path.
    public void uploadFile(String filePath) {
        uploadFileInput.sendKeys(filePath); // @param filePath The file path of the file to upload.
    }

    public void clickSubmit() {
        submitButton.click(); // Clicks the submit button to send the contact form.
    }

    
    // Checks if the success message is visible after form submission.
    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed(); // @return true if the success message is visible, false otherwise.
    }

    public void clickHome() {
        homeButton.click(); // Clicks the 'Home' button to navigate back to the home page.
    }
}

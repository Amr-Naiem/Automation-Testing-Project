package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
	public HomePage(WebDriver driver) 
	{
		super(driver);	
	}
	
	// Page Elements
	@FindBy(linkText = "Signup / Login")
	WebElement signUpLoginBtn; // Private for encapsulation
	
	
	// Page Methods (Actions)
	public void goToRegisterationPage()
	{
		signUpLoginBtn.click(); // Clicks the 'Signup / Login' button to navigate to the registration page.
	}	


}

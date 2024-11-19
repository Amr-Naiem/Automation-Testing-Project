package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	// Constructor to initialize the WebDriver and page elements
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Page Elements
	@FindBy(name="email")
	WebElement emailTxt; // Private for encapsulation
	
	@FindBy(name="password")
	WebElement passwordTxt; // Private for encapsulation
	
	@FindBy(css="button.btn.btn-default")
	WebElement loginBtn; // Private for encapsulation
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/h2")
	public WebElement loginMessage; // Public for access in tests
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/p")
	public WebElement failedMessage; // Public for access in tests
	
	@FindBy(partialLinkText = "Logged in as")
	public WebElement loginSuccessIndecator; // Public for access in tests
	
	// Performs login action using the provided email and password.
	public void userCanLogin(String email,String password){
		emailTxt.sendKeys(email); // @param email The user's email address.
		passwordTxt.sendKeys(password); // @param password The user's password.
		
		loginBtn.click();
	}
}

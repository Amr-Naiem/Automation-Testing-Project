package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage 
{
	// Constructor to initialize the WebDriver and elements on the page
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Page Elements
	@FindBy(name="name")
	WebElement signUpNameTxt;
	
	@FindBy(css="#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
	WebElement sigUpEmailTxt;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signUpBtn;
	
	@FindBy(id="id_gender1")
	WebElement genderBtn;
	
	@FindBy(id="password")
	WebElement passwordTxt;
	
	@FindBy(id="days")
	WebElement daysList;
	
	@FindBy(id="months")
	WebElement monthsList;
	
	@FindBy(id="years")
	WebElement yearsList;
	
	@FindBy(id="newsletter")
	WebElement newsLetterCheckBox;
	
	@FindBy(id="optin")
	WebElement specialOffersCheckBox;
	
	@FindBy(id="first_name")
	WebElement firstNameTxt;
	
	@FindBy(id="last_name")
	WebElement lastNameTxt;
	
	@FindBy(id="company")
	WebElement companyTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt1;
	
	@FindBy(id="address2")
	WebElement addressTxt2;
	
	@FindBy(id="country")
	WebElement countryList;
	
	@FindBy(id="state")
	WebElement stateTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="zipcode")
	WebElement zipCodeTxt;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumberTxt;
	
	@FindBy(css="#form > div > div > div > h2 > b")
	public WebElement successMessage;
	
	@FindBy(css = "button.btn.btn-default")
	WebElement createAccountBtn;
	
	@FindBy (css="#form > div > div > div:nth-child(3) > div > h2")
	public WebElement newUserSignUpMessage;
	
	@FindBy (css="#form > div > div > div > div.login-form > h2 > b")
	public WebElement EnterAccountInformationMessage;
	
	@FindBy(linkText = "Continue")
	WebElement continueBtn;
	
	/*@FindBy(tagName = "li")
	public List<WebElement> navBarList;
	*/
	@FindBy(partialLinkText = "Logged in as")
	public WebElement continueSuccessIndecator;
	
	@FindBy(partialLinkText = "Delete Account")
	WebElement deleletAccountBtn;
	
	@FindBy(css="#form > div > div > div > h2 > b")
	public WebElement deleteAccountMessage;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
	public WebElement failedMessage;
	
	// Fills in the signup form for a new user.
	public void newUserSignUp(String name,String email) 
	{
		signUpNameTxt.sendKeys(name); // @param name  The name of the user.
		sigUpEmailTxt.sendKeys(email); // @param email The email address of the user.
		signUpBtn.click();
		
		/*After First Click You Will Be Redirected To Fill Registration User Data Page*/
	} 
	
	// Fills in the user registration form.
	public void userRegisterationForm(String password,String day,String month, String year, String firstName, String lastName, String country, String company, String address1, String address2, String state, String city, String zipCode, String mobileNumber) 
	{	
		
		genderBtn.click();
		passwordTxt.sendKeys(password); // @param password The user's password.
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 350);");
		Select  makeDaysList= new Select(daysList); // @param day The user's birth day.
		Select  makeMonthsList= new Select(monthsList); // @param month The user's birth month
		Select  makeYearsList= new Select(yearsList); // @param year The user's birth year.
		Select  makeCountryList= new Select(countryList); // @param country The user's country.
		
		makeDaysList.selectByValue(day);
		makeMonthsList.selectByValue(month);
		makeYearsList.selectByValue(year);
		
		newsLetterCheckBox.click();
		specialOffersCheckBox.click();
		firstNameTxt.sendKeys(firstName); // @param firstName The user's first name.
		lastNameTxt.sendKeys(lastName); // @param lastName The user's last name.
		companyTxt.sendKeys(company); // @param company The user's company.
		addressTxt1.sendKeys(address1); // @param address1 The user's first address line.
		addressTxt2.sendKeys(address2); // @param address2 The user's second address line.
		makeCountryList.selectByValue(country);
		stateTxt.sendKeys(state); // @param state The user's state.
		cityTxt.sendKeys(city); // @param city The user's city
		zipCodeTxt.sendKeys(zipCode); // @param zipCode The user's zip code.
		mobileNumberTxt.sendKeys(mobileNumber); // @param mobileNumber The user's mobile number.
		
		createAccountBtn.click();

	}
	
	// Clicks the continue button after account creation.
	public void continueAccount()
	{
		continueBtn.click();
	}
	
	// Clicks the button to delete the account.
	public void deleteAccount() 
	{
		deleletAccountBtn.click();
	}
	
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
	public LogoutPage(WebDriver driver)
	{
		super(driver);
			
	}
	
	// Page Elements
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a" )
	WebElement logOutBtn; // Private for encapsulation

	// Page Methods (Actions)
	// Clicks the logout button to log the user out of the application.
	public void clickLogOut() throws InterruptedException
	{	
		
		logOutBtn.click(); // @throws InterruptedException if the thread is interrupted while sleeping
		Thread.sleep(3000);
	}	

}

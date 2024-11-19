package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;
	
	// Constructor to initialize the WebDriver and PageFactory elements
	public BasePage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Method to dismiss an alert on the webpage
	public void dismissAlert() 
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
}

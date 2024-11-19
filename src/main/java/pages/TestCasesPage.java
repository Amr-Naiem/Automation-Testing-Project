package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

	// Constructor to initialize the WebDriver and PageFactory elements
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div/h2/b")
    public WebElement testCasesHeader;
    
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    public WebElement testCasesBtn;
    
    // Page Methods (Actions)
    // Clicks on the Test Cases button to navigate to the Test Cases section.
    public void testCasesTittleClick() 
    {
    	testCasesBtn.click();
    }
    
    // Checks if the Test Cases page is visible by verifying the presence of the header.
    public boolean isTestCasesPageVisible() {
        return testCasesHeader.isDisplayed();// @return true if the Test Cases header is displayed, false otherwise.
    }
}

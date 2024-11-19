package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	 // Constructor to initialize the WebDriver and elements on the page
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartButton;  // Private access for encapsulation

    // Page Methods (Actions)
    public void clickCartButton() {
        cartButton.click(); // Clicks the 'Cart' button to navigate to the cart page.
    }
}

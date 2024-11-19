package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    WebElement productName;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    WebElement productCategory;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    WebElement productPrice;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
    WebElement productAvailability;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")
    WebElement productCondition;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")
    WebElement productBrand;

    @FindBy(xpath = "//input[@id='quantity']")
    WebElement quantityInput;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addToCartButton;

    @FindBy(partialLinkText  = "Cart")
    WebElement CartButton;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button") // Locator for quantity in cart
    WebElement cartQuantity;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;
    
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a")
    WebElement deleteProductBtn;
    
    // Page Methods (Actions)
    // Checks if the product detail elements are visible on the page.
    public boolean isProductDetailVisible() {
        return productName.isDisplayed() && productCategory.isDisplayed() &&
               productPrice.isDisplayed() && productAvailability.isDisplayed() &&
               productCondition.isDisplayed() && productBrand.isDisplayed(); // @return true if all product detail elements are displayed, otherwise false.
    }

    // Sets the quantity of the product in the quantity input field.
    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity); // @param quantity The desired quantity to be set.
    }

    public void clickAddToCart() {
        addToCartButton.click(); // Clicks the 'Add to Cart' button.
    }

    public void clickContinueShopping() {
        continueShoppingButton.click(); // Clicks the 'Continue Shopping' button.
    }
    
    public void clickViewCart() {
        CartButton.click(); // Clicks the 'Cart' button to view the cart.
    }

    // Retrieves the quantity of the product displayed in the cart.
    public String getCartProductQuantity() {
        return cartQuantity.getText(); // @return The quantity of the product in the cart as a String.
    }
    
    public void deleteProductFromCart() {
    
    	deleteProductBtn.click();// Clicks the button to delete the product from the cart.
    }
    
}
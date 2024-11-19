package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    WebElement allProductsHeader;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> productList;

    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    WebElement viewProductButton;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsBtn;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchInput;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    WebElement searchedProductsHeader;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> searchResultsList;

    @FindBy(xpath = ".//a[contains(text(),'Add to cart')]")
    WebElement clickAddToCartBtn;
    
    // Additional method for continuing shopping after adding a product to cart (if applicable)
    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;
    
    // Indicator that add to cart done correct and the Proceed To CheckOut Btn Appears 
    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    WebElement proceedToCheckoutBtn;
    
    // Method to click 'View Cart' button (assuming there's a button to view the cart)
    @FindBy(partialLinkText  = "Cart")
    WebElement viewCartButton;
    
    // Page Methods (Actions)
    // Checks if the All Products page is visible.
    public boolean isAllProductsPageVisible() {
        return allProductsHeader.isDisplayed(); // @return true if the All Products header is displayed, otherwise false.
    }

    // Checks if the product list is visible and contains products.
    public boolean isProductListVisible() {
        return productList.size() > 0; // @return true if the product list is not empty, otherwise false.
    }

    // Clicks the Products button to navigate to the Products page.
    public void clickProductsBtn() {
        productsBtn.click(); 
    }

    //  Clicks the first product's 'View Product' button.
    public void clickFirstProduct() {
        viewProductButton.click();
    }

    // Searches for a product by name.
    public void searchProduct(String productName) {
        searchInput.sendKeys(productName); // @param productName The name of the product to search for.
        searchButton.click();
    }
    
    // Clicks the 'Add to Cart' button for the first product.
    public void clickAddToCartBtn() 
    {
    	clickAddToCartBtn.click();
    }

    // Checks if the Searched Products header is visible.
    public boolean isSearchedProductsVisible() {
        return searchedProductsHeader.isDisplayed(); // @return true if the Searched Products header is displayed, otherwise false.
    }

    // Checks if there are any search results visible.
    public boolean areSearchResultsVisible() {
        return searchResultsList.size() > 0; // @return true if there are search results, otherwise false.
    }

    // Method to click 'Add to cart' for a specific product based on index
    public void clickAddToCart(int index) {
        if (index >= 0 && index < productList.size()) { // @param index The index of the product to add to cart.
            WebElement product = productList.get(index);
            Actions actions = new Actions(driver);
            actions.moveToElement(product).perform(); // Hover over the product
            product.findElement(By.xpath(".//a[contains(text(),'Add to cart')]")).click(); // Click 'Add to cart'
        } else {
            throw new IndexOutOfBoundsException("Product index out of range."); // @throws IndexOutOfBoundsException if the index is out of range.
        }
    }


    // Clicks the 'Continue Shopping' button.
    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    // Clicks the 'View Cart' button to navigate to the cart.
    public void clickViewCart() {
        viewCartButton.click();
    }

    // Example: Method to verify if the products are in the cart (could be customized further)
    public boolean areProductsInCart() {
       return (proceedToCheckoutBtn.isDisplayed()?true:false); // @return true if the Proceed To Checkout button is displayed, otherwise false.
    }
}

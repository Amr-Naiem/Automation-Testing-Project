package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {

	// Constructor to initialize the WebDriver and page elements
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    // Page Elements
    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    WebElement registerOrLoginButton;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentTextArea;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    WebElement placeOrder;
    
    @FindBy(name = "name_on_card")
    WebElement nameOnCardInput;

    @FindBy(name = "card_number")
    WebElement cardNumberInput;

    @FindBy(name = "cvc")
    WebElement cvcInput;

    @FindBy(name = "expiry_month")
    WebElement expiryMonthInput;

    @FindBy(name = "expiry_year")
    WebElement expiryYearInput;

    @FindBy(id = "submit")
    WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//p[contains(text(),'Your order has been placed successfully!')]")
    WebElement orderSuccessMessage;

    @FindBy(partialLinkText = "Delete Account")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueBtn;
    
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountDeletedMessage;

    // Page Methods (Actions)
    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click(); // Clicks the 'Proceed to Checkout' button.
    }

    public void clickRegisterOrLogin() {
        registerOrLoginButton.click(); // Clicks the 'Register or Login' button.
    }

    // Enters a comment in the comment text area and clicks the 'Place Order' button.
    public void enterComment(String comment) {
        commentTextArea.sendKeys(comment); // @param comment The comment to be entered.
        placeOrder.click();
    }

    // Enters payment details for the order.
    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expMonth, String expYear) {
        nameOnCardInput.sendKeys(nameOnCard); // @param nameOnCard The name on the card.
        cardNumberInput.sendKeys(cardNumber); // @param cardNumber The card number.
        cvcInput.sendKeys(cvc); // @param cvc The CVC code.
        expiryMonthInput.sendKeys(expMonth); // @param expMonth The expiry month.
        expiryYearInput.sendKeys(expYear); // @param expYear The expiry year.
    }

    // Clicks the 'Pay and Confirm Order' button.
    public void clickPayAndConfirmOrder() {
        payAndConfirmOrderButton.click();
    }

    // Checks if the order success message is visible.
    public boolean isOrderSuccessMessageVisible() {
        return orderSuccessMessage.isDisplayed(); // @return true if the success message is visible, otherwise false.
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click(); // Clicks the 'Delete Account' button.
    }

    public void clickContinueBtn() 
    {
    	continueBtn.click(); // Clicks the 'Continue' button.
    }
    
    // Checks if the account deleted message is visible.
    public boolean isAccountDeletedMessageVisible() {
        return accountDeletedMessage.isDisplayed(); // @return true if the account deleted message is visible, otherwise false.
    }
}

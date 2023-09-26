package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{


    @FindBy (className = "btn_action.checkout_button")
    private WebElement checkoutButton;
    @FindBy (className = "btn_secondary")
    private WebElement continueShoppingButton;
    @FindBy (className = "btn_secondary.cart_button")
    private WebElement removeButton;



    public CartPage (WebDriver driver, WebDriverWait driverWait) {
super(driver,driverWait);
    }

    public void removeFromCart () {
        removeButton.click();
        continueShoppingButton.click();
    }

}

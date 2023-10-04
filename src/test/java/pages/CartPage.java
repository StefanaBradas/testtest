package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static helper.ConstantsURL.CART_PAGE_URL;

public class CartPage extends BasePage {

    @FindBy(className = "checkout_button")
    private WebElement checkoutButton;

   @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[normalize-space()='REMOVE']")

    private WebElement removeButton;

    @FindBy(className = "cart_item")
    private List<WebElement> itemList;

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public List<WebElement> getItemList() {
        return itemList;
    }

    public void removeFromCart() {
        removeButton.click();
    }

    public void goToCheckout() {
        checkoutButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }

    public void assertLength(int expectedNumberOfItemColumns) {
        Assert.assertEquals(expectedNumberOfItemColumns, getItemList().size());
    }


    public void assertCartPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), CART_PAGE_URL);
    }


}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static helper.Constant.CART_PAGE_URL;

public class CartPage extends BasePage {

    @FindBy(className = "checkout_button")
    private WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button")
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
//        logger.setLevel(Level.WARNING);
    }

    public void assertLength(int expectedNumberOfItemColumns) {
        Assert.assertTrue(getItemList().size() == expectedNumberOfItemColumns);
    }


    public void assertCartPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), CART_PAGE_URL);
    }


    public void goToCheckout() {
        checkoutButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }

}

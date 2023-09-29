package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static helper.Constant.CHECKOUT_PAGE_URL;

public class CheckoutOverviewPage extends BasePage {


    @FindBy(className = "cart_cancel_link")
    private WebElement cancelButton;

    @FindBy(className = "btn_action")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    public CheckoutOverviewPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public WebElement getThankYouMessage() {
        return thankYouMessage;
    }


    public void finishPurchase() {
        finishButton.click();
    }

    public void cancelOrder() {
        cancelButton.click();
    }

    public void assertMessage(String expectedMessage) {
        Assert.assertEquals(getThankYouMessage().getText(), expectedMessage);
    }

    public void assertCheckoutPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), CHECKOUT_PAGE_URL);
    }


}

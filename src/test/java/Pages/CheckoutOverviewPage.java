package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends BasePage {

    WebElement cancelButton = driver.findElement(By.className("cart_cancel_link.btn_secondary"));
    WebElement finishButton = driver.findElement(By.className("btn_action.cart_button"));

    public CheckoutOverviewPage (WebDriver driver, WebDriverWait driverWait) {
        super(driver,driverWait);
    }


}

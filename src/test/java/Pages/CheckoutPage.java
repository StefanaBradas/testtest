package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {


    WebElement firstNameField = driver.findElement(By.id("We"));
    WebElement lastNameField = driver.findElement(By.id("last-name"));
    WebElement zipCodeField = driver.findElement(By.id("postal-code"));
    WebElement continueButton = driver.findElement(By.className("btn_primary.cart_button"));

    public CheckoutPage (WebDriver driver, WebDriverWait driverWait) {
        super(driver,driverWait);
    }




}

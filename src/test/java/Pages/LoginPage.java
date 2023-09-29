package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static helper.Constant.*;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }


    public void validLogin() {
        usernameField.click();
        usernameField.sendKeys(STANDARD_USER_USERNAME);
        passwordField.click();
        passwordField.sendKeys(STANDARD_USER_PASSWORD);
        loginButton.click();
    }

    public void assertLoginPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }


}

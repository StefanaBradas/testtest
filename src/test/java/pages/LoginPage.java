package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static helper.ConstantsForLogin.*;
import static helper.ConstantsURL.LOGIN_PAGE_URL;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/h3")

    private WebElement errorMessage;

    @FindBy

    Faker faker = new Faker();

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public void validLogin() {
        usernameField.sendKeys(STANDARD_USER_USERNAME);
        passwordField.sendKeys(STANDARD_USER_PASSWORD);
        loginButton.click();
    }

    public void invalidPasswordLogin() {
        usernameField.sendKeys(STANDARD_USER_USERNAME);
        passwordField.sendKeys(faker.internet().password());
        loginButton.click();
    }

    public void invalidUsernameLogin() {
        usernameField.sendKeys(faker.internet().password());
        passwordField.sendKeys(STANDARD_USER_PASSWORD);
        loginButton.click();
    }

    public void lockedOutUserLogin() {
        usernameField.sendKeys(LOCKED_OUT_USER);
        passwordField.sendKeys(STANDARD_USER_PASSWORD);
        loginButton.click();
    }

    public void assertErrorMessageText(String expectedMessage) {
        Assert.assertEquals(errorMessage.getText(), expectedMessage);
    }

    public void assertLoginPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }


}

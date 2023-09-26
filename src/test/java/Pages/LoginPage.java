package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy (id = "user-name" )
    private WebElement usernameField;
    @FindBy (id = "password")
    private  WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;


    public LoginPage (WebDriver driver, WebDriverWait driverWait) {
        super(driver,driverWait);
    }


    public void validLogin() {
        usernameField.click();
        usernameField.sendKeys("standard_user");
        passwordField.click();
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }


}

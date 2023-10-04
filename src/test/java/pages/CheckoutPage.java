package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {


    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement zipCodeField;
    @FindBy(className = "btn_primary")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void fillInformation() {
        Faker faker = new Faker();
        firstNameField.click();
        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.click();
        lastNameField.sendKeys(faker.name().lastName());
        zipCodeField.click();
        zipCodeField.sendKeys(faker.address().zipCode());
        continueButton.click();
    }

}

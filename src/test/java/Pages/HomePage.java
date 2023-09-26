package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/svg/path")
    private WebElement cart;

    @FindBy(xpath = "//*[@id='menu_button_container']/div/div[3]/div/button")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//*[@id='inventory_filter_container']/select")
    private WebElement sortingMenu;

    @FindBy(xpath = "//*[@id='inventory_container']/div/div[1]/div[3]/button")
    private WebElement addToCartButton1;
    @FindBy(xpath = "//*[@id='inventory_container']/div/div[5]/div[3]/button")
    private WebElement addToCartButton2;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

//    @FindBy(className = "btn_secondary cart_button")
//    private WebElement removeButton;


//    WebElement backButton = driver.findElement(By.className("inventory_details_back_button"));
////da li je ovo ok obzirom da je na drugom pageu da ne bi pravila posebnu stranicu

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logout() {
        dropDownMenu.click();
        logoutButton.click();
    }

    public void addToCart() {
        addToCartButton1.click();
        cart.click();
    }



}

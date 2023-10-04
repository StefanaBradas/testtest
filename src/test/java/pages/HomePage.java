package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.ConstantForLogin.LOW_TO_HIGH_PRICE_SORT;
import static helper.ConstantURL.*;

public class HomePage extends BasePage {


    @FindBy(id = "shopping_cart_container")
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

    @FindBy(className = "inventory_item_img")
    private WebElement image;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> listOfPrices;


    public List<Double> doubleList = new ArrayList<>();

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public void assertSortedList() {

        sortingMenu.click();

        Select select = new Select(sortingMenu);
        select.selectByVisibleText(LOW_TO_HIGH_PRICE_SORT);

        for (WebElement listOfPrice : listOfPrices) {
            String string = listOfPrice.getText().substring(1);
            double num = Double.parseDouble(string);
            doubleList.add(num);
        }

        List<Double> newList = new ArrayList<>(doubleList);
        Collections.sort(newList);

        Assert.assertEquals(doubleList, newList);
    }


    public WebElement getAddToCartButton1() {
        return addToCartButton1;
    }

    public void logout() {
        dropDownMenu.click();
        driverWaitUntilVisibilityOf(logoutButton);
        logoutButton.click();
    }

    public void addToCart() {
        addToCartButton1.click();
        cart.click();
    }

    public void seeDetailInfo() {
        image.click();
    }

    public void seeAboutSection() {
        dropDownMenu.click();
        driverWaitUntilVisibilityOf(aboutButton);
        aboutButton.click();
    }

    public void assertDetailInfoURL() {
        Assert.assertEquals(driver.getCurrentUrl(), DETAIL_INFO_URL);
    }

    public void assertAboutPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), ABOUT_SITE_URL);
    }

    public void assertElementIsDisplayed(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());
    }

    public void assertHomePageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), HOME_PAGE_URL);
    }

    public void driverWaitUntilVisibilityOf(WebElement webElement) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }


}

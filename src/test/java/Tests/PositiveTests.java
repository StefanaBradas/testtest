package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTests {



    @BeforeMethod
    public void beforeMethod() {
        driver.get(LOGIN_PAGE_URL);
        loginPage.validLogin();
    }

    @Test
    public void validLoginTest() {
        driver.get(LOGIN_PAGE_URL);
        loginPage.validLogin();
        Assert.assertEquals(driver.getCurrentUrl(), HOME_PAGE_URL);
    }

    @Test
    public void logoffTest() {
        loginPage.validLogin();
        homePage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }

    @Test
    public void addToCartTest() {
        homePage.addToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
        // koliko lista sadrzi itema

    }

    @Test
    public void removeFromCartTest() {
        homePage.addToCart();
        cartPage.removeFromCart();
        Assert.assertEquals(driver.getCurrentUrl(), HOME_PAGE_URL);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}

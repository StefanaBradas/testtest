package Tests;

import org.testng.annotations.Test;

import static helper.Constant.LOGIN_PAGE_URL;
import static helper.Constant.SUCCESSFUL_PURCHASE_MESSAGE;


public class PositiveTests extends BaseTests {

    @Test
    public void validLoginTest() {
        driver.get(LOGIN_PAGE_URL);
        loginPage.validLogin();
        homePage.assertHomePageURL();
    }

    @Test
    public void validLoginTestaaaaaaaaaaa() {
        driver.get(LOGIN_PAGE_URL);
        loginPage.validLogin();
        homePage.assertHomePageURL();
    }

    @Test
    public void logoffTest() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }

    @Test
    public void logoffTestAB() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }

    @Test
    public void logoffTests() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }
    @Test
    public void logoffTests25() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }

    @Test
    public void logoffTests2() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }

    @Test
    public void addToCartTest() {
        homePage.addToCart();
        cartPage.assertCartPageURL();
        cartPage.assertLength(1);
    }

    @Test
    public void removeFromCartTest() {
        homePage.addToCart();
        cartPage.removeFromCart();
        logger.warn("Clicked on remove button");
        cartPage.assertCartPageURL();
        cartPage.assertLength(0);
    }

    @Test
    public void sortingByLowestPriceTest() {
        homePage.assertSortedList();
    }

    @Test
    public void successfulPurchaseTest() {
        homePage.addToCart();
        cartPage.goToCheckout();
        checkoutPage.fillInformation();
        checkoutOverviewPage.finishPurchase();
        checkoutOverviewPage.assertCheckoutPageURL();
        checkoutOverviewPage.assertMessage(SUCCESSFUL_PURCHASE_MESSAGE);
    }

    @Test
    public void continueShoppingFromCartPageTest() {
        homePage.addToCart();
        cartPage.continueShopping();
        homePage.assertHomePageURL();
    }

    @Test
    public void detailInfoTest() {
        homePage.seeDetailInfo();
        homePage.assertDetailInfoURL();
    }

    @Test
    public void cancelingOrderTest() {
        homePage.addToCart();
        cartPage.goToCheckout();
        checkoutPage.fillInformation();
        checkoutOverviewPage.cancelOrder();
        homePage.assertHomePageURL();
        homePage.assertElementIsDisplayed(homePage.getAddToCartButton1());
    }

    @Test
    public void aboutMeTest() {
        homePage.seeAboutSection();
        homePage.assertAboutPageURL();
    }

}

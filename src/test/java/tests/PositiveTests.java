package tests;


import org.testng.annotations.Test;

import static helper.ConstantsForLogin.SUCCESSFUL_PURCHASE_MESSAGE;
import static helper.ConstantsURL.LOGIN_PAGE_URL;

public class PositiveTests extends BaseTests {

    @Test (groups = {"regressionTests", "end-to-endTests"})
    public void validLoginTest() {
        driver.get(LOGIN_PAGE_URL);
        loginPage.validLogin();

        homePage.assertHomePageURL();
    }

    @Test (groups = {"end-to-endTests"})
    public void logoffTest() {
        homePage.logout();
        loginPage.assertLoginPageURL();
    }


    @Test (groups = {"regressionTests"})
    public void addToCartTest() {
        homePage.addToCart();

        cartPage.assertCartPageURL();
        cartPage.assertLength(1);
    }

    @Test
    public void removeFromCartTest() {
        homePage.addToCart();
        cartPage.removeFromCart();
        cartPage.assertCartPageURL();
        cartPage.assertLength(0);
    }

    @Test(groups = {"end-to-endTests"})
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
        checkoutOverviewPage.assertSuccessfulMessage(SUCCESSFUL_PURCHASE_MESSAGE);
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

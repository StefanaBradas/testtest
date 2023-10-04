package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static helper.ConstantForLogin.INVALID_LOGIN_MESSAGE;
import static helper.ConstantForLogin.LOCKED_OUT_USER_LOGIN_MESSAGE;
import static helper.ConstantURL.LOGIN_PAGE_URL;


public class NegativeTests extends BaseTests {

    @BeforeMethod
    public void beforeMethod () {
        driver.get(LOGIN_PAGE_URL);
    }

    @Test
    public void invalidPasswordLoginTest() {
        loginPage.invalidPasswordLogin();
        loginPage.assertLoginPageURL();
        loginPage.assertErrorMessageText(INVALID_LOGIN_MESSAGE);
    }

    @Test
    public void invalidUsernameLoginTest() {
        loginPage.invalidUsernameLogin();
        loginPage.assertLoginPageURL();
        loginPage.assertErrorMessageText(INVALID_LOGIN_MESSAGE);
    }

    @Test
    public void lockedOutUserLoginTest() {
        loginPage.lockedOutUserLogin();
        loginPage.assertLoginPageURL();
        loginPage.assertErrorMessageText(LOCKED_OUT_USER_LOGIN_MESSAGE);
    }



}

package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.InputMismatchException;
import java.util.Objects;

import static helper.ConstantsForLogin.*;
import static helper.ConstantsURL.LOGIN_PAGE_URL;


public class NegativeTests extends BaseTests {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(LOGIN_PAGE_URL);
    }

//    @Test
//    public void invalidPasswordLoginTest() {
//        test = extent.createTest("lala test name", "lala test desccription");
//
//            loginPage.invalidPasswordLogin();
//            loginPage.assertLoginPageURL();
//
//            if (loginPage.assertErrorMessageText2(INVALID_LOGIN_MESSAGE)) {
//                System.out.println("PASSSS");
//                test.log(Status.PASS, "test passed");
//            } else {
//                System.out.println("FAILLLLLLL");
//                test.log(Status.FAIL, "fail");
//            }
//
//        extent.flush();
//
//    }



    @Test
    public void invalidUsernameLoginTest() {

        test = extent.createTest("test 2", "lala test desccription");

        try {
            loginPage.invalidUsernameLogin();
            loginPage.assertLoginPageURL();
            loginPage.assertErrorMessageText("lala");
        } catch (AssertionError ex) {
            test.log(Status.FAIL, ex);
            throw ex;
        }
        extent.flush();

    }

//    @Test
//    public void lockedOutUserLoginTest() {
//        test = extent.createTest("test 3", "lala test desccription");
//
//        loginPage.lockedOutUserLogin();
//        loginPage.assertLoginPageURL();
//        loginPage.assertErrorMessageText(LOCKED_OUT_USER_LOGIN_MESSAGE);
//
//        extent.flush();
//    }



}

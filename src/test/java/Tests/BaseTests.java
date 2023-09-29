package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


import static helper.Constant.*;


public abstract class BaseTests {

    public WebDriver driver;
    WebDriverWait driverWait;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    Logger logger;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        initializePager();

        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        loginPage.validLogin();

        logger = LogManager.getLogger(BaseTests.class.getName());
    }

    public void initializePager() {
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        cartPage = new CartPage(driver, driverWait);
        checkoutPage = new CheckoutPage(driver, driverWait);
        checkoutOverviewPage = new CheckoutOverviewPage(driver, driverWait);
    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }


}

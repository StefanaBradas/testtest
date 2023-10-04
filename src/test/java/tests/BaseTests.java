package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;

import static helper.ConstantURL.LOGIN_PAGE_URL;

public abstract class BaseTests {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverviewPage checkoutOverviewPage;


    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(String browserName) {
        WebDriverManager.chromedriver().setup();

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        initializePager();
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        loginPage.validLogin();
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

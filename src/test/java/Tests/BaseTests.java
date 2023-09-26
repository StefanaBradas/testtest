package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public abstract class BaseTests {

    public WebDriver driver;
    WebDriverWait driverWait;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;


@BeforeClass
public void initialize() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
     driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

      loginPage = new LoginPage(driver, driverWait);
      homePage = new HomePage(driver, driverWait);
      cartPage = new CartPage(driver, driverWait);
}

String HOME_PAGE_URL = "https://www.saucedemo.com/v1/inventory.html";
String LOGIN_PAGE_URL = "https://www.saucedemo.com/v1/index.html";


}

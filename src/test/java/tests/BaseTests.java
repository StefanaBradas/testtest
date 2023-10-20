package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;

import static helper.ConstantsURL.LOGIN_PAGE_URL;

public abstract class BaseTests {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeAll
    public void beforeAll () {


//        extent = new ExtentReports();
//        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
//
//        sparkReporter.config().setOfflineMode(true);
//        sparkReporter.config().setDocumentTitle("Simple automation Report");
//        sparkReporter.config().setReportName("Test report");
//        sparkReporter.config().setTheme(Theme.STANDARD);
//        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zz')'");
//        sparkReporter.config().setEncoding("UTF-8");
//
//        extent.attachReporter(sparkReporter);


//        sparkReporter.config(
//                ExtentSparkReporterConfig.builder()
//                        .theme(Theme.STANDARD)
//                        .documentTitle("My report")
//                        .offlineMode(true)
//                        .build()
//        );                                           // OVO JE DRUGI NACIN

    }

//    @BeforeSuite
//    public void beforeSuite () {
//        extent = new ExtentReports();
//        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
//
//        sparkReporter.config().setOfflineMode(true);
//        sparkReporter.config().setDocumentTitle("Simple automation Report");
//        sparkReporter.config().setReportName("Test report");
//        sparkReporter.config().setTheme(Theme.STANDARD);
//        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zz')'");
//        sparkReporter.config().setEncoding("UTF-8");
//
//        extent.attachReporter(sparkReporter);
//
//    }

    @Parameters("browserName")
    @BeforeMethod (groups = {"regressionTests", "end-to-endTests"})
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

    @AfterMethod (groups = {"regressionTests", "end-to-endTests"})
    public void afterClass() {
        driver.quit();
    }


}

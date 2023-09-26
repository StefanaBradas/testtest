package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

protected WebDriver driver;
protected WebDriverWait driverWait;

    public BasePage (WebDriver webDriver,WebDriverWait driverWait) {
        this.driver = webDriver;
        this.driverWait=driverWait;
        PageFactory.initElements(driver, this);
    }


}

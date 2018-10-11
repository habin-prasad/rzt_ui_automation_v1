package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j

/**
 * author: habin,
 * created on: 25/09/18 : 5:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public abstract class BaseClass {
    public static final int WAIT_TIME_IN_SECS = 10;
    static final int WAIT_TIME_IN_MILLISECS = 10000;
    protected static boolean IS_ADMIN;
    private static ReadProperties readProperties = new ReadProperties("/driver_config.properties");
    public static final String baseUrl = readProperties.getValue("qa");
    public WebDriver driver;
    protected Logger log = LogManager.getLogger(BaseClass.class.getName());
    protected ExcelUtility excelUtility;
    protected MouseActivity mouseActivity;
    protected WaitEx waitEx;
    protected Screenshots screenshots;
    protected TestBase testBase = new TestBase();
    protected ToastHandler toastHandler;
    protected JavascriptExecutor js;

    public static boolean isIsAdmin() {
        return IS_ADMIN;
    }

    public static void setIsAdmin(boolean isAdmin) {
        IS_ADMIN = isAdmin;
    }

    public void setUp() {
        this.driver = selectBrowser();
        this.driver = implicitDriverWait(WAIT_TIME_IN_SECS);
        this.driver = maximizeWindow();
        driver.get(baseUrl);

    }

    private WebDriver selectBrowser() {
        String webDriver = readProperties.getValue("browser");
        if (webDriver.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (webDriver.equalsIgnoreCase("phantomjs")) {
            WebDriverManager.iedriver();
            driver = new InternetExplorerDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;
    }

    private WebDriver maximizeWindow() {
        this.driver.manage().window().fullscreen();
        return this.driver;
    }

    protected WebDriver implicitDriverWait(int timeInSeconds) {
        this.driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
        return this.driver;
    }


    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForLoader(WebDriver driver, By element) {
        waitEx = new WaitEx(driver);
        return waitEx.waitForElementToBeClickable(element, 30);
    }

    public WebElement waitforElementPresentInDOM(WebDriver driver, By element) {
        waitEx = new WaitEx(driver);
        return waitEx.ifElementPresentInDOM(element, 30);
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public abstract void verifyAddress(String address);

    public void verifyText(String actual, String expected) {
        testBase.verifyEquals(actual, expected, driver);
    }


    public abstract void verifyTitle(String title);
}

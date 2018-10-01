package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

/**
 * author: habin,
 * created on: 25/09/18 : 5:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BaseClass {
    public static final int WAIT_TIME_IN_SECS = 10;
    protected static final Logger log = LogManager.getLogger(BaseClass.class.getName());
    static final int WAIT_TIME_IN_MILLISECS = 10000;
    protected WebDriver driver;
    protected ExcelUtility excelUtility;
    protected MouseActivity mouseActivity;
    protected WaitEx waitEx;
    protected Screenshots screenshots;
    private ReadProperties readProperties = new ReadProperties("/driver_config.properties");

    public void setUp() {
        String baseUrl = readProperties.getValue("qa");
        this.driver = selectBrowser();
        this.driver = maximizeWindow();
        this.driver = implicitDriverWait(WAIT_TIME_IN_SECS);
        driver.get(baseUrl);
    }

    private WebDriver selectBrowser() {
        String webDriver = readProperties.getValue("browser");
        if (webDriver.equalsIgnoreCase("chrome")) {
            String directoryName = System.getProperty("user.dir") + "/drivers/";
            System.setProperty("webdriver.chrome.driver", directoryName + "chromedriver");
            driver = new ChromeDriver();
        } else if (webDriver.equalsIgnoreCase("safari"))
            driver = new SafariDriver();
        else
            driver = new FirefoxDriver();

        return driver;
    }

    private WebDriver maximizeWindow() {
        this.driver.manage().window().maximize();
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


}

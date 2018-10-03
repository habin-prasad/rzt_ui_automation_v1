package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * author: habin,
 * created on: 28/09/18 : 1:44 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BaseTestClass {
    public WebDriver driver;
    protected TestBase testBase = new TestBase();


    public void setUp(String webDriver, String baseUrl) {
        this.driver = selectBrowser(webDriver);
        this.driver = maximizeWindow();
        this.driver = implicitDriverWait(20);
//        System.out.println("Base Url:  "+baseUrl);
        driver.get(baseUrl);
    }

    private WebDriver selectBrowser(String webDriver) {
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

    private WebDriver implicitDriverWait(int timeInSeconds) {
        this.driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
        return this.driver;
    }

//    private void verifyPageTitle(String title) {
//        testBase.verifyEquals(driver.getTitle(), title);
//    }


    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

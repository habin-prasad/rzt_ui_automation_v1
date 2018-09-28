package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * author: habin,
 * created on: 28/09/18 : 1:44 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BaseTestClass {
    protected WebDriver driver;

    @Parameters({"webDriver", "baseUrl"})
    public void setUp(String webDriver, String baseUrl) {
        if (webDriver.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (webDriver.equalsIgnoreCase("safari"))
            driver = new SafariDriver();
        else
            driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


}

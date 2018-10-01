package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: habin,
 * created on: 25/09/18 : 5:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BaseClass {
static Validations validations;
static ExcelUtility excelUtility;
static MouseActivity mouseActivity;
static WaitEx waitEx;
static Screenshots screenshots;
static WebDriver driver;
static String baseUrl = "https://bbqanew.razorthink.net/";


    public static WebDriver launchSetUp(){
        String directoryName = System.getProperty("user.dir") + "/drivers/";
        System.setProperty("webdriver.chrome.driver",directoryName+"chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }
}

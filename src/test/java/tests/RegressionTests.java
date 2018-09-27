package tests;

import base.CustomTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testPages.LoginPageTest;
import utils.ReadProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:48 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@Listeners(CustomTestListener.class)
public class RegressionTests {
    private WebDriver driver;
    private String baseUrl;
    private ReadProperties readProperties;


    @BeforeClass
    public void setUp() {
        readProperties = new ReadProperties();
        String directoryName = System.getProperty("user.dir") + "/drivers/";
        System.setProperty("webdriver.chrome.driver", directoryName + "chromedriver");
        driver = new ChromeDriver();
//        baseUrl=readProperties.getPropertyValue("stg");
//        baseUrl = "https://bbstaging-in.razorthink.net";
        baseUrl = "https://bbqanew.razorthink.net";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test(priority = 1)
    public void loginPageTest() {
        LoginPageTest loginPageTest = new LoginPageTest(driver);
        loginPageTest.validateTitle("Razorthink AI");
        loginPageTest.login("","");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

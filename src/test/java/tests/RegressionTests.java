package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import testPages.LoginPageTest;

import java.util.concurrent.TimeUnit;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:48 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class RegressionTests {
    private WebDriver driver;
    private String baseUrl;


    @BeforeClass
    public void setUp(){
        String directoryName = System.getProperty("user.dir") + "/drivers/";
        System.setProperty("webdriver.chrome.driver",directoryName+"chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://bbqanew.razorthink.net/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void loginPageTest(){
        LoginPageTest loginPageTest = new LoginPageTest(driver);
        loginPageTest.validateTitle("Razorthink AIs");
        loginPageTest.login("","");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}

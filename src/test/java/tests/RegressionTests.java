package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
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


    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void loginPageTest(){
        LoginPageTest loginPageTest = new LoginPageTest(driver);
        loginPageTest.validateTitle("Razorthink AI");
        loginPageTest.login("habin.prasad@razorthink.com","@ssh0ole");
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}

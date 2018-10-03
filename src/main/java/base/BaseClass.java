package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author: habin,
 * created on: 25/09/18 : 5:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BaseClass {
    protected Validations validations;
    protected ExcelUtility excelUtility;
    protected MouseActivity mouseActivity;
    protected WaitEx waitEx;
    protected Screenshots screenshots;
    public WebDriver driver;
    public String baseUrl;
    public Properties properties;
    public String timeInSeconds;



    public BaseClass() {
        FileInputStream fileInput = null;
        try {
            File file = new File("/home/kajal/IdeaProjects/rzt_ui_automation_v1/src/main/java/Config/config.properties");
            fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void setUp(String webDriver) {
        this.driver = selectBrowser(webDriver);
        this.driver = maximizeWindow();
        driver.manage().deleteAllCookies();
        timeInSeconds = properties.getProperty(timeInSeconds);
        this.implicitWait(Integer.parseInt(timeInSeconds));
//        System.out.println("Base Url:  "+baseUrl);
        baseUrl = properties.getProperty(baseUrl);
        driver.get(baseUrl);
    }

    private WebDriver selectBrowser(String webDriver) {
        if (webDriver.equalsIgnoreCase("chrome")) {
            String directoryName = System.getProperty("user.dir") + "/drivers/";
            System.setProperty("WebDriver.chrome.driver", directoryName + "chromedriver");
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

    private WebDriver implicitWait(int timeInSeconds) {
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

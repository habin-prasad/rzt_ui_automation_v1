package pages;

import base.BaseClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

/**
 * author: habin,
 * created on: 25/09/18 : 5:56 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@Log4j2
public class LoginPage extends BaseClass {


    @FindBy(xpath = "//button[contains(.,'Continue with Google')]")
    private WebElement ldapLoginButton;

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement userName;

    @FindBy(xpath = "//span[contains(.,'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPassword;


    public LoginPage() {
        setUp();
        PageFactory.initElements(super.driver, this);
        waitEx = new WaitEx(this.driver);
    }

    public WebDriver login(String uname, String pwd) {
        log.info("Login to the Application using Google creds");
        ldapLoginButton.click();
        waitEx.waitElement(By.xpath("//input[@id='identifierId']"), 4000);
        enterUserName(uname);
        waitEx.waitElement(By.xpath("//input[@name='password']"), 4000);
        enterPassword(pwd);
        waitForLoader(driver, By.xpath("//img"));
        return this.driver;
    }

    private void enterUserName(String username) {
        userName.clear();
        userName.sendKeys(username);
        nextButton.click();
        log.info("Username entered");
    }

    private void enterPassword(String password) {
        userPassword.clear();
        userPassword.sendKeys(password);
        try{
            nextButton.click();
        } catch (Exception e) {
            userPassword.sendKeys(Keys.ENTER);
            log.error(e.getMessage());
        }
        log.info("Password entered");
    }

   public String returnTitle() {
      return driver.getTitle();
    }


    @Override
    public void verifyAddress(String address) {

        log.info("Address verification Method");
    }

    @Override
    public void verifyTitle(String pageTitle) {

        testBase.verifyEquals(driver.getTitle(), pageTitle, driver);
    }


    public String getMethodName()
    {
       String testcase = new Object(){}.getClass().getEnclosingMethod().getName();
       return testcase;
    }
}

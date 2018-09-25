package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

/**
 * @author: habin,
 * created on: 25/09/18 : 5:56 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class LoginPage {

    private WebDriver driver;
    private WaitEx waitEx;

    @FindBy(xpath = "//button[contains(.,'Sign in with Razorthink')]")
    private WebElement ldapLoginButton;

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPassword;

//    @FindBy(xpath = "//div[@id='identifierNext']")
//    private WebElement nextButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(this.driver);
    }

    public WebDriver login(String uname, String pwd) {
        ldapLoginButton.click();
        waitEx.waitElement(By.xpath("//input[@id='identifierId']"), 4000);
        userName.clear();
        userName.sendKeys(uname);
        nextButton.click();
        waitEx.waitElement(By.xpath("//input[@name='password']"), 4000);
        userPassword.clear();
        userPassword.sendKeys(pwd);
        nextButton.click();

        return this.driver;
    }


}

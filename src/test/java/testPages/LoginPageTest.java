package testPages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import utils.Validations;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LoginPageTest extends BaseClass {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginPageTest(WebDriver driver){
        this.driver = driver;
        validations = new Validations(this.driver);

    }
    public void validateTitle(String title){
        validations.validateTitle(title);
    }

    public void login(String uname, String upass){
        loginPage = new LoginPage(driver);
        loginPage.login(uname,upass);
    }


}

package testPages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Validations;

/**
 * author: habin,
 * created on: 25/09/18 : 6:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LoginPageTest {
    private LoginPage loginPage;
    private Validations validations = new Validations();


    @BeforeSuite(alwaysRun = true)
    @Parameters({"webDriver", "baseUrl"})
    public void settingUp(String webDriver, String baseUrl)
    {
        loginPage = new LoginPage(webDriver);
    }


    @Test(groups = "loginP")
    @Parameters({"loginTitle"})
    public void validatePTitle(String title) {
        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);


    }

    @Test(groups = "loginP")
    @Parameters({"username", "password", "loginTitle"})
    public void login(String username, String password, String title) {
        loginPage.login(username, password);
        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
     }

    @AfterTest
    public void tearDown() {
        loginPage.driver.quit();
//        loginPage.tearDown();
    }

}

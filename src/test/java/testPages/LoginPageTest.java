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
    public void settingUp() {
        loginPage = new LoginPage();
    }


    @Test(groups = "loginP", priority = 1)
    @Parameters({"loginTitle"})
    public void validatePTitle(String title) {
        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
    }

    @Test(groups = "loginP", priority = 2)
    @Parameters({"username", "password", "loginTitle"})
    public void login(String username, String password, String title) {
        loginPage.login(username, password);
        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        loginPage.driver.quit();
    }

}

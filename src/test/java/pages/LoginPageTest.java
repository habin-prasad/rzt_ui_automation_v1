package pages;

import base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Validations;

/**
 * author: habin,
 * created on: 25/09/18 : 6:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LoginPageTest {
    private LoginPage loginPage;
    private Validations validations = new Validations();


    @BeforeGroups(alwaysRun = true, groups = {"loginP"})
    public void settingUp() {
        loginPage = new LoginPage();
    }


    @Test(groups = {"loginP"}, priority = 2)
    @Parameters({"loginTitle"})
    public void validatePTitle(String title) {
//        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
        loginPage.verifyTitle(title);
    }

    @Test(groups = {"loginP"}, priority = 1)
    @Parameters({"username", "password"})
    public void login(String username, String password) {
        loginPage.login(username, password);
//        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
    }

    @AfterClass(alwaysRun = true, groups = {"loginP"})
    public void tearDown() {

        BaseClass.driver.quit();
    }

}

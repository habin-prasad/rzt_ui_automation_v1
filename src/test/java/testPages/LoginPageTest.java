package testPages;

import base.BaseTestClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LoginPageTest extends BaseTestClass {
    private LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"webDriver", "baseUrl"})
    public void settingUp(String WebDriver, String baseUrl) {
        setUp(WebDriver, baseUrl);
    }


    @Test(groups = {"loginP"})
    @Parameters({"loginTitle"})
    public void validatePTitle(String title) {
        testBase.verifyEquals(driver.getTitle(), title, driver);
    }

    @Test(groups = {"loginP"})
    @Parameters({"username", "password"})
    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        setDriver(driver);
    }

    @AfterSuite
    public void tearingDown() {
        tearDown();
    }

}

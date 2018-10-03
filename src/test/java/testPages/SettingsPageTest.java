package testPages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SettingsPage;
import utils.Validations;

/**
 * author: habin,
 * created on: 28/09/18 : 12:02 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SettingsPageTest {

    private SettingsPage settingsPage;
    private Validations validations = new Validations();

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void navigateToSettingsPage(String username, String password) {
        settingsPage = new SettingsPage(username, password);
        settingsPage.goSettingsPage();
    }

    @Test(priority = 1, groups = {"settings"}, singleThreaded = true)
    @Parameters("loginTitle")
    public void verifyTitle(String title) {
        validations.verifyEquals(title, settingsPage.returnTile(), settingsPage.driver);
    }


    @Test(priority = 2, groups = {"settings"}, singleThreaded = true)
    @Parameters({"baseUrl"})
    public void verifyUsersManagementTab(String baseUrl) {
        validations.verifyEquals(settingsPage.driver.getCurrentUrl(), baseUrl + "/settings/users", settingsPage.driver);
        WebElement usersPage = settingsPage.getUserPageElement();
        validations.verifyEquals(usersPage.getAttribute("aria-current"), "page", settingsPage.driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        settingsPage.driver.quit();
    }


}

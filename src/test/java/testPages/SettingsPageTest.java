package testPages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SettingsPage;

/**
 * author: habin,
 * created on: 28/09/18 : 12:02 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SettingsPageTest {

    private SettingsPage settingsPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void navigateToSettingsPage(String username, String password) {
        settingsPage = new SettingsPage(username, password);
    }

    @Test(priority = 3, groups = {"settings"})
    @Parameters("loginTitle")
    public void verifyTitle(String title) {
        settingsPage.verifyTitle(title);
    }


    @Test(priority = 4, groups = {"settings"})
    public void verifyUsersManagementTab() {
        settingsPage.verifyAddress("/settings/users");
        settingsPage.verifyAttribute("page");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        settingsPage.driver.quit();
    }


}

package testPages;

import base.BaseTestClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SettingsPage;

/**
 * author: habin,
 * created on: 28/09/18 : 12:02 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SettingsPageTest extends BaseTestClass {
    private WebDriver driver;
    //    private TestBase testBase;
    private SettingsPage settingsPage;

//    @FindBy(linkText = "Users")
//    private WebElement usersPage;

    @BeforeClass(alwaysRun = true)
    public void navigateToSettingsPage() {
        this.driver = getDriver();
        settingsPage = new SettingsPage(driver);
        settingsPage.clickUsersTab();
    }

    @Test(dependsOnGroups = "loginP", priority = 1, groups = {"settings", "userM"})
    @Parameters("loginTitle")
    public void verifyTitle(String title) {
        testBase.verifyEquals(driver.getTitle(), title, driver);
    }


    @Test(dependsOnGroups = "loginP", priority = 2, groups = {"settings", "userM"})
    @Parameters({"baseUrl"})
    public void verifyUsersManagementTab(String baseUrl) {
        testBase.verifyEquals(driver.getCurrentUrl(), baseUrl + "/settings/users", driver);
        WebElement usersPage = settingsPage.getUserPageElement();
        testBase.verifyEquals(usersPage.getAttribute("aria-current"), "page", driver);
    }


}

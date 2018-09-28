package testPages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * author: habin,
 * created on: 28/09/18 : 12:02 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SettingsPageTest {
    private WebDriver driver;
    private TestBase testBase;

    @FindBy(linkText = "Users")
    private WebElement usersPage;

    public SettingsPageTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        testBase = new TestBase();
    }


    @Test
    @Parameters({"baseUrl"})
    public void verifyUsersManagementTab(String baseUrl) {
        testBase.verifyEquals(driver.getCurrentUrl(), baseUrl + "/settings/users", driver);
        testBase.verifyEquals(usersPage.getAttribute("aria-current"), "page", driver);
    }


}

package pages.admin;

import base.BaseClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.WaitEx;

import java.util.Arrays;
import java.util.List;

/**
 * author: habin,
 * created on: 26/09/18 : 4:40 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Log4j2
public class LeftPanel extends LoginPage {

    @FindBy(xpath = "//span[@title='Profile']/parent::span")
    private WebElement profileIcon;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@title='Workspace']/parent::span")
    private WebElement workSpaceIcon;

    @FindBy(xpath = "//span[@title='Jupyter']/parent::span")
    private WebElement jupyterIcon;

    @FindBy(xpath = "//span[@title='Settings']/parent::span/parent::a")
    private WebElement settingsIcon;

    @FindBy(xpath = "//span[@title='Support']/parent::span")
    private WebElement supportIcon;

    @FindBy(xpath = "//img")
    private WebElement rztIcon;

    @FindBy(css = "div[class^='ProfilePopup__userRoles']>span:nth-child(1)")
    private WebElement rolesLabel;

    @FindBy(css = "div[class*='userEmail']")
    private WebElement userEmail;

    public LeftPanel(String username, String password) {
        super();
        login(username, password);
        PageFactory.initElements(super.driver, this);
        waitEx = new WaitEx(driver);
        setIsAdmin(isAdmin());
    }

    public void logout() {
        profileIcon.click();
        logoutButton.click();
    }

    public void goHomePage() {
        rztIcon.click();
    }

    public void openJupyter() {
        jupyterIcon.click();
    }

    public void goSettingsPage() {
        try {
            Thread.sleep(5000);
            settingsIcon.click();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void getSupport() {
        supportIcon.click();
    }

    public boolean isAdmin() {
        clickProfileIcon();
        boolean flag = false;

        try {
            String[] roles = rolesLabel.getAttribute("title").split(",");
            List rolesList = Arrays.asList(roles);
            flag = rolesList.contains("Admin");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        testBase.verifyTrue(flag, driver);
        return flag;
    }

    @Override
    public void verifyAddress(String address) {

        testBase.verifyEquals(driver.getCurrentUrl(), BaseClass.baseUrl + address, driver);
    }


    @Override
    public void verifyTitle(String pageTitle) {

        testBase.verifyEquals(driver.getTitle(), pageTitle, driver);
    }

    public void setEmailVar() {
        clickProfileIcon();
        setEMAIL(userEmail.getText());
    }

    private void clickProfileIcon() {
        try {
            Thread.sleep(5000);
            profileIcon.click();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


}

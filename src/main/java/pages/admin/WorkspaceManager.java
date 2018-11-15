package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ToastHandler;
import utils.Validations;

/**
 * author: habin,
 * created on: 17/10/18 : 12:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WorkspaceManager extends Users {
    private String userName = "";

    @FindBy(css = "button[class^='WorkspaceM']")
    private WebElement clearAllIcon;

    @FindBy(xpath = "//button[contains(.,'DISABLED USERS')]")
    private WebElement disabledUsersTab;

    public WorkspaceManager(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    private void selectUser(String useremail) {
        boolean flag = true;
        userName = getUserName(useremail);
        flag = isUserDisabled(useremail);
        log.info("User is disabled: " + flag);
        log.info("Navigating back to Workspace Manager Tab");
        clickWorkspaceManagerTab();
        if (flag) disabledUsersTab.click();
        log.info("Searching for user with user name as: " + userName);
        By byPath = By.xpath("//div[@title='" + userName + "']/parent::div//label[1]");
        WebElement userCheckbox = waitEx.waitElement(byPath, 5);
        log.info("Selecting the checkbox for the found user");
        userCheckbox.click();

    }

    private void clickDeleteAllIcon() {
        log.info("Clicking on clear all icon");
        clearAllIcon.click();
    }

    private void acceptWarning() {
        toastHandler = new ToastHandler(driver);
        log.info("Accepting the warning of loosing the user data");
        toastHandler.clickOkButton();
    }

    public void clearUserWorkSpace(String useremail) {
        validations = new Validations();
        log.info("Validating Email " + useremail + " and found: " + validations.isValidEmailAddress(useremail));
        log.info("Getting user name mapped with the email");
        selectUser(useremail);
        clickClearIcon(userName);
        acceptWarning();
    }

    private void clickClearIcon(String user) {
        By byXpath = By.xpath("//div[@title='" + user + "']/parent::div//button[starts-with(@class,'WorkspaceUsersTable')]");
        WebElement clearIcon = waitEx.waitElement(byXpath, 5);
        clearIcon.click();
    }

}

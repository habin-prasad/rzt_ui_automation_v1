package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * author: habin,
 * created on: 26/09/18 : 5:39 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SettingsPage extends LeftPanel {


    @FindBy(linkText = "Users")
    private WebElement usersTab;

    @FindBy(linkText = "Roles & Permission")
    private WebElement rolesTab;

    @FindBy(linkText = "License and Usage")
    private WebElement licenseTab;

    @FindBy(linkText = "Audit Manager")
    private WebElement auditTab;

    @FindBy(linkText = "Engine Manager")
    private WebElement engineTab;

    @FindBy(linkText = "Update Manager")
    private WebElement updateTab;

    @FindBy(linkText = "Workspace Manager")
    private WebElement workspaceTab;

    @FindBy(linkText = "Open Requests")
    private WebElement openRequestsTab;

    @FindBy(linkText = "Library Manager")
    private WebElement libraryTab;


    public SettingsPage(String username, String password) {
        super(username, password);
        log.info("Navigating to Settings page");
        goSettingsPage();
        PageFactory.initElements(driver, this);
    }

    public void clickUsersTab() {
        usersTab.click();
    }

    public void clickRolesTab() {
        log.info("Clicking on Users Tab");
        rolesTab.click();
    }

    public void clickLicenseTab() {
        licenseTab.click();
    }

    public void clickAuditTab() {
        auditTab.click();
    }

    public void clickEngineTab() {
        engineTab.click();
    }

    public void clickUpdateTab() {
        updateTab.click();
    }

    public void clickWorkspace() {
        workspaceTab.click();
    }

    public void clickOpenRequests() {
        openRequestsTab.click();
    }

    public void clickLibrary() {
        libraryTab.click();
    }


    public WebElement getUserPageElement() {
        return usersTab;
    }

    public String returnTile() {
        return driver.getTitle();
    }

    public void verifyAttribute(String attributeValue) {
        verifyText(usersTab.getAttribute("aria-current"), attributeValue);
    }


}

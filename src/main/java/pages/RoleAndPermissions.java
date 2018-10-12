package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MouseActivity;
import utils.ToastHandler;

import java.util.Arrays;
import java.util.List;

/**
 * author: habin,
 * created on: 01/10/18 : 6:10 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class RoleAndPermissions extends SettingsPage {

    private final int SLEEP_TIME = 5000;
    String title;
    private List<String> baseRoles = Arrays.asList("Platform Credit Expiry", "Owner", "Admin"
            , "Internal System", "Edit", "System Manager", "View", "Deployer", "Executor", "User");

    @FindBy(xpath = "//button[contains(text(),'Add New Role')]")
    private WebElement addNewRoleButton;

    @FindBy(css = "div[class^= 'EditableText' ] > span:nth-child(1)")
    private List<WebElement> webElementList;

    @FindBy(css = "div[class ^='EditableContent__wrapper']")
    private List<WebElement> descList;

    @FindBy(css = "div[class^= 'EditableText' ] > input[title='click to edit']")
    private WebElement activeElement;

    @FindBy(css = "span[contenteditable='plainttext-only'][class^='EditableContent']")
    private WebElement activeDescArea;

    @FindBy(css = "div[class^='PermissionsAccordion'] > div")
    private List<WebElement> permissionList;

    @FindBy(css = "button[title='Copy']")
    private List<WebElement> copyRoleButtonsList;

    @FindBy(css = "button[title='Delete']")
    private List<WebElement> deleteElementList;


    public RoleAndPermissions(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    public void addNewRole(String roleLabel) {
        if (roleLabel.length() < 3) {
            log.error("Invalid name length");
            throw new ArithmeticException("Atleast 3 character long name is expected !!" + roleLabel);
        }
        addNewRoleButton.click();
        activeElement.sendKeys(roleLabel);
        waiter();
        activeElement.sendKeys(Keys.ENTER);
        log.info("Added role with label : " + roleLabel);
    }

    public void addNewRole(String roleLabel, String desc) {
        addNewRole(roleLabel);
        WebElement element = descList.get(0);
        element.click();
        activeDescArea.sendKeys(desc);
        activeDescArea.sendKeys(Keys.ENTER);
    }

    public boolean ifUserRoleAdded(String roleLabel) {

        boolean flag = false;
        for (WebElement element : webElementList) {
            title = element.getAttribute("title");
            if (roleLabel.equals(title)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            log.info("Success !! Role added found");
            testBase.verifyEquals(title, roleLabel, driver);
            return flag;
        } else {
            log.error("Role with the roleLabel " + roleLabel + " not found !!");
            testBase.verifyFalse(true, driver);
            return false;
        }
    }

    public void copyRole(String roleLabel) {
        waiter();
        log.info("Copying role with lable: " + roleLabel);
        if (!ifUserRoleAdded(roleLabel)) {
            testBase.verifyTrue(false, driver);
            log.error("Given role: " + roleLabel + " not present in the roles list to copy");
            return;
        }

        WebElement copyButton = copyRoleButtonsList.get(getPosition(roleLabel));
        copyButton.click();
        log.info("Successfully Copied the role with label: " + roleLabel);
    }

    public void ifRoleCopied(String roleLabel) {
        driver.navigate().refresh();
        for (WebElement element : webElementList) {
            if ((element.getAttribute("title").contains(roleLabel + " copy"))) {

                testBase.verifyTrue(true, driver);
                return;
            }
        }
        testBase.verifyTrue(false, driver);
    }

    public void deleteRole(String roleLabel) {

        refreshPage();
        log.info("Deleting role with lable: " + roleLabel);
        if (baseRoles.contains(roleLabel)) {
            log.error("Default roles should not be deleted");
            testBase.verifyFalse(true, driver);
            return;
        }


        WebElement element = deleteElementList.get(getPosition(roleLabel));
        element.click();
        toastHandler = new ToastHandler(driver);
        toastHandler.clickOkButton();
        log.info("Successfully deleted the role with label: " + roleLabel);
    }

    public boolean ifUserRoleDeleted(String roleLabel) {
        boolean flag = false;
        log.info("Refreshing the page");
        refreshPage();
        for (WebElement element : webElementList) {
            title = element.getAttribute("title");
            if (roleLabel.equals(title)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            log.info("Fail !! Role added found");
            testBase.verifyFalse(true, driver);
            return flag;
        } else {
            log.error("Success role with the roleLabel " + roleLabel + " not found !!");
            testBase.verifyFalse(false, driver);
            return false;
        }
    }

    private void refreshPage() {
        driver.navigate().refresh();
        waiter();
    }

    private void waiter() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void deleteAllRoles() {
        if (webElementList.size() == baseRoles.size())
            return;
        for (WebElement element : webElementList) {
            int attempts = 0;
            while (attempts < 2) {
                try {
                    title = element.getAttribute("title");
                } catch (StaleElementReferenceException e) {

                }
                attempts++;
            }
            title = element.getAttribute("title");
            if (!title.equalsIgnoreCase("") && !baseRoles.contains(title)) {
                log.info("Deleted the title: " + title);
                deleteRole(title);
                webElementList = driver.findElements(By.cssSelector("div[class^= 'EditableText' ] > span"));
            }

        }
    }

    private void editName(String roleLabel, String newLabel) {
        WebElement element = webElementList.get(getPosition(roleLabel));
        mouseActivity = new MouseActivity(driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + newLabel + "'", element);
        log.info("Edited the Role label: " + roleLabel + " with new Label: " + newLabel);
    }

    private void editDescription(String roleLabel, String desc) {
        WebElement element = descList.get(getPosition(roleLabel));
        element.click();
        element.clear();
        element.sendKeys(desc);
        waiter();
        element.sendKeys(Keys.ENTER);
        log.info("Edited the description of Role: " + roleLabel);
    }

    public void updateRole(String roleLabel, String newLabel, String description) {
        waiter();
        editName(roleLabel, newLabel);
        refreshPage();
//        editDescription(newLabel, description);
        log.info("Updated the Role.");
    }

    private int getPosition(String roleLabel) {
        int pos = 0;
        for (WebElement element : webElementList) {
            if (roleLabel.equalsIgnoreCase(element.getAttribute("title"))) {
                pos = webElementList.indexOf(element);
                break;
            }
        }
        return pos;
    }

}

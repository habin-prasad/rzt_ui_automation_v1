package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * author: habin,
 * created on: 01/10/18 : 6:10 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class RoleAndPermissions extends SettingsPage {

    @FindBy(xpath = "//button[contains(text(),'Add New Role')]")
    private WebElement addNewRoleButton;

    @FindBy(css = "div[class^= 'EditableText' ] > span")
    private List<WebElement> webElementList;

    @FindBy(css = "div[class ^='EditableContent__wrapper']")
    private List<WebElement> descList;

    @FindBy(css = "div[class^= 'EditableText' ] > input[title='click to edit']")
    private WebElement activeElement;

    @FindBy(css = "span[contenteditable='plainttext-only'][class^='EditableContent']")
    private WebElement activeDescArea;

    @FindBy(css = "div[class^='PermissionsAccordion'] > div")
    private List<WebElement> permissionList;


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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
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

    public void ifUserRoleAdded(String roleLabel) {
        String title = "";
        boolean flag = false;
        log.info("Refreshing the page");
        driver.navigate().refresh();
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
        } else {
            log.error("Role with the roleLabel " + roleLabel + " not found !!");
            testBase.verifyFalse(true);
        }

    }


}

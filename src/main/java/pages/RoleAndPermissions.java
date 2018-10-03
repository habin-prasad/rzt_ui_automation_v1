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
    private WebElement descList;


    public RoleAndPermissions(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    public void addNewRole(String roleLabel) {
        if (roleLabel.length() < 3) {
            log.error("Invalid name length");
            throw new ArithmeticException("Atleast 3 character long name is expected !!");
        }
        addNewRoleButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Adding role with label : " + roleLabel);
        driver.switchTo().activeElement().sendKeys(roleLabel);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        log.info("Added role with label : " + roleLabel);
    }

    public void ifUserRoleAdded(String roleLabel) {
        log.info("Refreshing the page");
        driver.navigate().refresh();
        for (WebElement element : webElementList) {
            if (roleLabel.equals(element.getAttribute("title"))) {
                log.info("Success !! Role added found");
                testBase.verifyEquals(element.getAttribute("title"), roleLabel, driver);
            } else {
                log.error("Role with the roleLabel " + roleLabel + " not found !!");
                testBase.verifyFalse(true);
            }
        }

    }


}

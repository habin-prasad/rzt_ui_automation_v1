package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * author: habin,
 * created on: 01/10/18 : 6:10 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class RoleAndPermissions {

    @FindBy(xpath = "//button[contains(text(),'Add New Role')]")
    private WebElement addNewRoleButton;

    @FindBy(css = "div[class^='EditableTest'] > input")
    private WebElement enterRoleName;


}

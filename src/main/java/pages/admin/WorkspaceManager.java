package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: habin,
 * created on: 17/10/18 : 12:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WorkspaceManager extends Users {
    @FindBy(css = "button[class^='WorkspaceM']")
    private WebElement clearAllIcon;

    public WorkspaceManager(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    public void selectUser(String useremail) {
        String userName = getUserName(useremail);
//        WebElement element = driver.findElement(By.xpath("//div[@title='" +userName + "']/parent::div//label[1]"));
        By byPath = By.xpath("//div[@title='" + userName + "']/parent::div//label[1]");
        WebElement userCheckbox = waitEx.waitElement(byPath, 5000);
        userCheckbox.click();


    }


}

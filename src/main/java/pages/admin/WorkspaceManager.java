package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: habin,
 * created on: 17/10/18 : 12:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WorkspaceManager extends Users {


    public WorkspaceManager(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    public void selectUser(String useremail) {

        WebElement element = driver.findElement(By.xpath("//div[@title='" + useremail + "']/parent::div//label[1]"));

    }


}

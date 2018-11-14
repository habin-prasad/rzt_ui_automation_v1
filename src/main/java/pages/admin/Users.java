package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: habin,
 * created on: 31/10/18 : 10:39 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Users extends SettingsPage {

    public Users(String username, String password) {
        super(username, password);
        clickUsersTab();
        PageFactory.initElements(driver, this);
    }

    protected String getUserName(String email) {
        WebElement element = driver.findElement(By.xpath("//div[@title='" + email + "']/parent::div/div[1]"));
        return element.getAttribute("title");
    }
}

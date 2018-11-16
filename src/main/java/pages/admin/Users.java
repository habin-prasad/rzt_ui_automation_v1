package pages.admin;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * author: habin,
 * created on: 31/10/18 : 10:39 AM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class Users extends SettingsPage {
    private String logMessage1 = "Navigating to Users Tab";
    private String logMessage2 = "Searching for user tag with email: ";

    public Users(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    protected String getUserName(String email) {
        log.info(logMessage1);
        clickUsersTab();
        WebElement user = null;
        try {
            log.info(logMessage2 + email);
            By byXpath = By.xpath("//div[@title='" + email + "']/parent::div/div[1]");
            user = waitEx.waitElement(byXpath, 5);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return user.getAttribute("title");
        }
    }


    protected void activateDeactivateUser(String email) {
        log.info(logMessage1);
        clickUsersTab();
        WebElement toggleButton;
        try {
            log.info(logMessage2 + email);
            By byXpath = By.xpath("//div[@title='" + email + "']/parent::div//div[starts-with(@class,'ToggleButton')]");
            toggleButton = waitEx.waitElement(byXpath, 5);
            log.info("Clicking toggle button");
            toggleButton.click();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public boolean isUserDisabled(String email) {
        log.info(logMessage1);
        clickUsersTab();
        WebElement toggleButton;
        boolean flag = false;
        try {
            log.info(logMessage2 + email);
            By byXpath = By.xpath("//div[@title='" + email + "']/parent::div//div[starts-with(@class,'ToggleButton')]/button");
            toggleButton = waitEx.waitElement(byXpath, 5);
            if (toggleButton.getAttribute("class").contains("disabled"))
                flag = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return flag;
    }


}

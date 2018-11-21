package pages.admin;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * author: habin,
 * created on: 31/10/18 : 10:39 AM
 * To change this template use File | Settings | File and Code Templates.
 */

@Log4j2
public class Users extends SettingsPage {
    private String logMessage1 = "Navigating to Users Tab";
    private String logMessage2 = "Searching for user tag with email: ";

    @FindBy(xpath = "//div[contains(@class,'userContent')]/div[2]")
    private List<WebElement> displayedUserElements;

    @FindBy(xpath = "//div[contains(@class,'noRecords')]")
    private WebElement noMoreElement;

    @FindBy(xpath = "//div[contains(@class,'userslist')]")
    private WebElement usersDiv;

    public Users(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    private List<String> getUsersList() {
        List<String> usersEmailList = new ArrayList<>();
        for (WebElement e : displayedUserElements) {
            usersEmailList.add(e.getAttribute("title"));
        }
        return usersEmailList;
    }

    @NotNull
    protected String getUserName(String email) {
        log.info(logMessage1);
        clickUsersTab();
        js = (JavascriptExecutor) driver;
        WebElement user = null;
        String userName = "";
        scrollToGetEmelement(email);
        try {
            log.info(logMessage2 + email);
            By byXpath = By.xpath("//div[@title='" + email + "']/parent::div/div[1]");
            user = waitEx.waitElement(byXpath, 5);
            js.executeScript("arguments[0].scrollIntoView(true)", user);
            userName = user.getAttribute("title");
            log.info("Found the user :" + userName + " for email: " + email);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userName;
    }

    private void scrollToGetEmelement(String email) {
        js = (JavascriptExecutor) driver;
        boolean flag = false;
        log.info("Traversing through out the users list for getting user details");
        while (!flag) {
            js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", usersDiv);
            if (getUsersList().contains(email)) flag = true;
        }
    }


    protected void activateDeactivateUser(String email) {
        log.info(logMessage1);
        clickUsersTab();
        js = (JavascriptExecutor) driver;
        scrollToGetEmelement(email);
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
        js = (JavascriptExecutor) driver;
        scrollToGetEmelement(email);
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

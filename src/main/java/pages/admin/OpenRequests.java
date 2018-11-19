package pages.admin;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * author: habin,
 * created on: 19/11/18 : 10:56 AM
 * To change this template use File | Settings | File and Code Templates.
 */

@Log4j2
public class OpenRequests extends Users {

    @FindBy(xpath = "//button[starts-with(@class,'OpenRequestsTable')]")
    private List<WebElement> openRequestLists;

    public OpenRequests(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
    }

    private boolean verifyIfOpenRequestsPresent() {
        return !openRequestLists.isEmpty();
    }

    public final void acceptOpenRequest(String userEmail) {
        String userName = getUserName(userEmail);
        respondToRequest(true, userName);
    }

    public final void cancelOpenRequest(String userEmail) {
        String userName = getUserName(userEmail);
        respondToRequest(false, userName);
    }

    @NotNull
    @Contract(pure = true)
    private String getPath(String user, String icon) {
        return "//div[contains(text(),'" + user + "')]/parent::div//span[contains(@class,'" + icon + "')]";
    }

    private void respondToRequest(boolean b, String userName) {
        clickOpenRequests();
        if (verifyIfOpenRequestsPresent()) {
            if (b) {
                log.info("Accepting the open request of user: " + userName);
                WebElement tickIcon = driver.findElement(By.xpath(getPath(userName, "tick")));
                tickIcon.click();
            } else {
                log.info("Cancelling the open request of user: " + userName);
                WebElement cancelIcon = driver.findElement(By.xpath(getPath(userName, "close")));
                cancelIcon.click();
            }
        } else {
            log.error("No Open Requests present to edit");
        }
    }
}

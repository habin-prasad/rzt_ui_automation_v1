package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

/**
 * @author: habin,
 * created on: 26/09/18 : 4:40 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LeftPanel extends LoginPage {
//    private final WebDriver webDriver;
//    private LoginPage loginPage;

    @FindBy(xpath = "//span[@title='Profile']/parent::span")
    private WebElement profileIcon;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@title='Workspace']/parent::span")
    private WebElement workSpaceIcon;

    @FindBy(xpath = "//span[@title='Jupyter']/parent::span")
    private WebElement jupyterIcon;

    @FindBy(xpath = "//span[@title='Settings']/parent::span/parent::a")
    private WebElement settingsIcon;

    @FindBy(xpath = "//span[@title='Support']/parent::span")
    private WebElement supportIcon;

    @FindBy(xpath = "//img")
    private WebElement rztIcon;

    public LeftPanel(String webDriver, String baseUrl, String username, String password) {
        super(webDriver, baseUrl);
//        new LoginPage(webDriver, baseUrl);
        login(username, password);
        PageFactory.initElements(super.driver, this);
        waitEx = new WaitEx(super.driver);
    }

    public void logout() {
        profileIcon.click();
        logoutButton.click();
    }

    public void goHomePage() {
        rztIcon.click();
    }

    public void openJupyter() {
        jupyterIcon.click();
    }

    public void goSettingsPage() {
//        waitEx.waitElement(By.xpath("//img"),4000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        settingsIcon.click();
    }

    public void getSupport() {
        supportIcon.click();
    }

}

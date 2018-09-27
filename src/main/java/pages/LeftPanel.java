package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: habin,
 * created on: 26/09/18 : 4:40 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LeftPanel {
    private WebDriver driver;

    @FindBy(xpath = "//span[@title='Profile']/parent::span")
    private WebElement profileIcon;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@title='Workspace']/parent::span")
    private WebElement workSpaceIcon;

    @FindBy(xpath = "//span[@title='Jupyter']/parent::span")
    private WebElement jupyterIcon;

    @FindBy(xpath = "//span[@title='Settings']/parent::span")
    private WebElement settingsIcon;

    @FindBy(xpath = "//span[@title='Support']/parent::span")
    private WebElement supportIcon;

    @FindBy(xpath = "//img")
    private WebElement rztIcon;

    public LeftPanel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);

    }

    public void logout(){
        profileIcon.click();
        logoutButton.click();
    }

    public void goHomePage(){
        rztIcon.click();
    }

    public void openJupyter(){
        jupyterIcon.click();
    }

    public void goSettingsPage(){
        settingsIcon.click();
    }

    public void getSupport(){
        supportIcon.click();
    }

}

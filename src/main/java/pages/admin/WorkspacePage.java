package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class WorkspacePage extends LeftPanel {

    //@FindBy(xpath = "//div[@classname='SecondaryHeader__rightChildContainer___1EJ3_']")
    //div[@id='mainContainer']/div//div[@class='App__pageWrapperInner___EIS2A']
    //private WebElement upload;

    @FindBy(xpath = "//a[@href='/workspace']")
    private WebElement workspace;

    @FindBy(xpath = "//button[contains(.,'Upload')]") //div[@id='mainContainer']/div/div[2]/div[2]//button[@title='']
    private WebElement uploadFiles;

    @FindBy(xpath = "//input[@title='Choose File']")
    private WebElement ChooseFileLink;

    @FindBy(xpath = "//div[@id='popupPortal']//span[.='Uploaded']")
    private WebElement Uploaded;

    @FindBy(xpath = "//div[@id='popupPortal']/div/div/div[3]/button[2]")
    private WebElement ClickDone;

    @FindBy(xpath = "//button[@title='Download']")
    private WebElement downloadMyspaceFiles;

    @FindBy(xpath = "")
    private WebElement deleteMyspaceFile;

    @FindBy(xpath = "")
    private WebElement makeMyspaceFilePublic;

    @FindBy(xpath = "")
    private WebElement navigateToCommunity;

    @FindBy(xpath = "")
    private WebElement copyFromCommunityToMyspace;

    @FindBy(xpath = "")
    private WebElement downloadFromCommunity;

    public WorkspacePage(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(this.driver);
        //goWorkspace();
    }

    public void goToWorkspace() {
        workspace.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void verifyTitle(String pageTitle) {
        testBase.verifyEquals(driver.getTitle(), pageTitle, driver);
    }


    public void uploadFiles() throws AWTException {
        uploadFiles.click(); //open upload
        //ChooseFileLink.sendKeys("\\home\\kajal\\Downloads\\PopulationEstimates.csv");
        ChooseFileLink.click();
        //put path of file in a clipboard
        StringSelection ss = new StringSelection("\\home\\kajal\\DataSets\\PopulationEstimates.csv");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void downloadFilesFromMyspace() {
        List<WebElement> downloadfilelist = downloadMyspaceFiles.findElements(By.linkText("download"));

    }

    public void deleteFilesFromMyspace() {

    }

    public void makeMyspaceFilePublic() {

    }

    public void navigateToCommunity() {

    }

    public void copyFileFromCommunityToMyspace() {


    }

    public void downloadFilesFromCommunity() {

    }

    public void tearDown() {
        driver.quit();
    }
}


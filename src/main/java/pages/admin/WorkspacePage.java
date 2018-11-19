package pages.admin;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

@Log4j2
public class WorkspacePage extends LeftPanel{

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

    //@FindBy(xpath = "//div[@class='WorkspaceChild__content___3Z7zR']//div[@name='tbody-rttable']//div/div[1]//button[@title='Download']")
    @FindBy(xpath = "//div[1]/div/div[6]/?/?/button[@title='Download']")
    private  WebElement downloadMyspaceFiles;

    @FindBy(xpath = "//div[1]/div/div[6]/div/button[@title='Delete']")
    private WebElement deleteMyspaceFile;

    @FindBy(xpath = "//div[1]/div/div[5]/span[@safeclass~'\\bMySpaceTable__cellText___QsLD4\\b']/div[@role='button']")
    private WebElement makeMyspaceFilePublicTogle;

    @FindBy(xpath = "//a[@pathname='/workspace/community-space']/button[@title='Community Space']")
    private WebElement navigateToCommunity;

    @FindBy(xpath = "//div[1]/div/div[6]/?/?/button[@title='Copy To My Space']")
    private WebElement copyFromCommunityToMyspace;

    @FindBy(xpath = "//div[1]/div/div[6]/?/?/button[@title='Download']")
    private WebElement downloadFromCommunity;

    public WorkspacePage(String username, String password) {
        super(username, password);
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(this.driver);
    }

    public void goToWorkspace() {
        workspace.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void verifyTitle(String pageTitle) {
        testBase.verifyEquals(driver.getTitle(), pageTitle, driver);
    }


    public void uploadFiles() throws AWTException {
        uploadFiles.click();
        //ChooseFileLink.sendKeys("/home/kajal/DataSets/PopulationEstimates.csv");
        //ChooseFileLink.sendKeys("/home/kajal/DataSets/fifa_ranking.csv");
        ChooseFileLink.click();
        StringSelection ss = new StringSelection("/home/kajal/DataSets/PopulationEstimates.csv");
        //Copy the path of file in a clipboard
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
        ClickDone.click();
    }

    public void downloadFilesFromMySpace(){

        downloadMyspaceFiles.click();
    }

    public void deleteFilesFromMyspace(){
        deleteMyspaceFile.click();
    }

    public void makeMyspaceFilePublic(){
        makeMyspaceFilePublicTogle.isEnabled();
    }

    public void navigateToCommunity(){
        navigateToCommunity.click();
    }

    public void copyFileFromCommunityToMyspace(){
        copyFromCommunityToMyspace.click();
    }

    public void downloadFilesFromCommunity(){
        downloadFromCommunity.click();
    }

    @Override
    public void tearDown() {

        driver.quit();
    }
}


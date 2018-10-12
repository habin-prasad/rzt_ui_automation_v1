package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

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
        //goWorkspace();
    }

    public void goToWorkspace(){
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


    public void uploadFiles(){
        uploadFiles.click(); //open upload
        ChooseFileLink.sendKeys("/home/kajal/DataSets/PopulationEstimates.csv");
        ChooseFileLink.sendKeys("/home/kajal/DataSets/fifa_ranking.csv");
        ClickDone.click();
        //ChooseFileLink.click();
        //put path of file in a clipboard
        //StringSelection ss = new StringSelection("\\home\\kajal\\DataSets\\PopulationEstimates.csv");
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);
        //robot.keyPress(KeyEvent.VK_CONTROL);
        //robot.keyPress(KeyEvent.VK_V);
        //robot.keyRelease(KeyEvent.VK_V);
        //robot.keyRelease(KeyEvent.VK_CONTROL);
        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);
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

     public void tearDown(){

        driver.quit();
     }
}


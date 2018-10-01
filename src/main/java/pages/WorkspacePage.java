package pages;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

public class WorkspacePage {

    static WebDriver driver;
    private WaitEx waitEx;


    //@FindBy(xpath = "//div[@classname='SecondaryHeader__rightChildContainer___1EJ3_']")
    //private WebElement upload;
    @FindBy(xpath = "//a[@href='/workspace']//span[@title='Workspace']")
    private WebElement workspace;

    @FindBy(xpath = "//button[contains(.,'Upload')]") //div[@id='mainContainer']/div/div[2]/div[2]//button[@title='']
    private WebElement uploadFiles;

    @FindBy(xpath = "//input[@title='Choose File']")
    private WebElement ChooseFileLink;

    @FindBy(xpath = "//div[@id='popupPortal']//span[.='Uploaded']")
    protected WebElement Uploaded;

    @FindBy(xpath = "//div[@id='popupPortal']/div/div/div[3]/button[2]")
    private WebElement ClickDone;


    public WorkspacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(this.driver);
    }

    public WebDriver uploadFiles(){
        // Navigate to Workspace
        workspace.click();

        //Click on Upload Button
        uploadFiles.click();
        //ChooseFileLink.click();

        //Choose Files and submit
        ChooseFileLink.sendKeys("drive:\\home\\kajal\\Downloads\\PopulationEstimates.csv");
        return this.driver;
    }

}


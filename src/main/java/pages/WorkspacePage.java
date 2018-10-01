package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitEx;

public class WorkspacePage {

    private WebDriver driver;
    private WaitEx waitEx;

    //@FindBy(xpath = "//div[@classname='SecondaryHeader__rightChildContainer___1EJ3_']")
    //private WebElement upload;

    @FindBy(xpath = ".//button[contains(.,'Upload')]")
    private WebElement upload;

    @FindBy(xpath = ".//a[@href='/workspace']")
    private WebElement workspace;

    public WorkspacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitEx = new WaitEx(this.driver);
    }

    public WebDriver Upload() {
        upload.click();
        return this.driver;
    }

}


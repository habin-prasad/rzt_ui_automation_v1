package pages.projects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitEx;

/**
 * author: habin,
 * created on: 13/11/18 : 5:55 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Log4j2
public class CanvasPage extends ProjectsPage {
    public CanvasPage(String username, String password) {
        super(username, password);

    }

    protected void moveInstancewithName(String instanceName) {
        waitEx = new WaitEx(driver);
        By byPath = By.xpath("//span[contains(.,'" + instanceName + "')]/parent::div[starts-with(@class,'Block')]");
        WebElement element = waitEx.waitElement(byPath, 5);
        element.getText();
    }

    protected void navigateToCanvas(String pipelineName) {
        waitEx = new WaitEx(driver);
        By byXpath = By.xpath("//span[@title='" + pipelineName + "']/ancestor::div[2]//button[@title='Edit']");
        WebElement editicon = waitEx.waitElement(byXpath, 5);
        editicon.click();
    }
}

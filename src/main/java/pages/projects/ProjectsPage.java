package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.admin.LeftPanel;
import utils.WaitEx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: habin,
 * created on: 26/09/18 : 5:37 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ProjectsPage extends LeftPanel {

    @FindBy(css = "div[class^='Project'] > span")
    private List<WebElement> projects;


    public ProjectsPage(String username, String password) {
        super(username, password);
        waitEx = new WaitEx(driver);
    }

    private void clickOnModuleIcon(String projectName, String modulePath) {
        By byPath = By.xpath("//span[@title='" + projectName + "']/ancestor::div[4]//span[starts-with(@class,'flaticon-" + modulePath + "')]");
        WebElement element = waitEx.waitElement(byPath, 5000);
        element.click();
    }

    public void navigateTo(String projectName, String module) {
        if (checkIfUniqueProjectName(projectName)) {
            switch (module.toLowerCase()) {
                case "pipeline":
                    clickOnModuleIcon(projectName, "pipeline");
                    break;
                case "runexplorer":
                    clickOnModuleIcon(projectName, "run");
                    break;
                case "model":
                    clickOnModuleIcon(projectName, "models");
                    break;
                case "recipe":
                    clickOnModuleIcon(projectName, "data");
                    break;
            }
        } else log.error("Multiple project with same name exists. Please provide unique name");
    }

    private boolean checkIfUniqueProjectName(String projectName) {
        List<String> projectNames = new ArrayList<>();
        for (WebElement elem : projects) {
            projectNames.add(elem.getAttribute("title"));
        }
        return projectNames.lastIndexOf(projectName) == projectNames.indexOf(projectName);
    }



}

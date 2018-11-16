package pages.projects.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.projects.CanvasPage;
import utils.WaitEx;

import java.util.ArrayList;
import java.util.List;

/**
 * author: habin,
 * created on: 13/11/18 : 5:35 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class PipelineListPage extends CanvasPage {

    @FindBy(css = "div[class^='Editable']")
    private List<WebElement> pipelines;

    public PipelineListPage(String username, String password) {
        super(username, password);
        waitEx = new WaitEx(driver);
    }

    public void navigateToPipelineListPage(String projectName) {
        navigateTo(projectName, "pipeline");
    }


    private boolean verifyIfMulitplePipelinePresent(String pipelineName) {
        List<String> pipelineNames = new ArrayList<>();
        for (WebElement element : pipelines) {
            pipelineNames.add(element.getAttribute("title"));
        }
        return pipelineNames.lastIndexOf(pipelineName) == pipelineNames.indexOf(pipelineName);
    }

    public void editPipelineAndSave(String pipelineName, String blockName) {
        navigateToCanvas(pipelineName);
    }

}

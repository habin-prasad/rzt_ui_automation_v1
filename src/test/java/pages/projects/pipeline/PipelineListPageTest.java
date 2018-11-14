package pages.projects.pipeline;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author: habin,
 * created on: 14/11/18 : 4:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class PipelineListPageTest {
    private PipelineListPage pipelineListPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void setUp(String username, String password) {
        pipelineListPage = new PipelineListPage(username, password);
    }

    @Test(priority = 801, groups = {"pipeline"})
    @Parameters({"projectName"})
    public void navigateToPipelineListPage(String projectName) {
        pipelineListPage.navigateToPipelineListPage(projectName);
    }

    @Test(priority = 802, groups = {"pipeline"})
    @Parameters({"pipelineName", "blockInstance"})
    public void navigateToCanvas(String pipelineName, String blockInstance) {
        pipelineListPage.editPipelineAndSave(pipelineName, blockInstance);
    }


}
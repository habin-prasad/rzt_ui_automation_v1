package pages.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * author: habin,
 * created on: 30/10/18 : 6:05 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WorspaceManagerTest {
    private WorkspaceManager workspaceManager;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void setUp(String username, String password) {
        workspaceManager = new WorkspaceManager(username, password);
        workspaceManager.clickWorkspaceManagerTab();
    }

    @Test(priority = 701, groups = "workspaceManager")
    @Parameters("userEmail")
    public void clearUserWorkspace(String userEmail) {
        workspaceManager.clearUserWorkSpace(userEmail);
    }

    @Test(priority = 702, groups = "workspaceManager")
    @Parameters({"userEmail", "errorMessage1"})
    public void validateErrorMessage(String userEmail, String errorMessage) {
        workspaceManager.verifyErrorMessage(errorMessage, userEmail);
    }

    @AfterClass(alwaysRun = true)
    public void closeAll() {
        workspaceManager.tearDown();
    }

}

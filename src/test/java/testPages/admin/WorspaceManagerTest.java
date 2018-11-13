package testPages.admin;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.admin.WorkspaceManager;

/**
 * @author: habin,
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

    @Test
    @Parameters("userEmail")
    public void checkUserExists() {

    }

}

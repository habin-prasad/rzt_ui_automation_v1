package testPages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.WorkspacePage;

import java.awt.*;

public class WorkspacePageTest {

    private WorkspacePage workspacePage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void navigateToWorkspace(String username, String password) {
        workspacePage = new WorkspacePage(username, password);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workspacePage.goToWorkspace();
    }

        @Test(priority = 2, groups = {"workspace"})
        public void fileUploadTest()
        {
            workspacePage.uploadFiles();
        }


        @Test(priority = 1, groups = {"workspace"})
        @Parameters({"pageTitle"})
        public void verifyTitle(String pageTitle)
        {
            workspacePage.verifyTitle(pageTitle);
        }


        @Test(priority = 3, groups = {"workspace"})
        public void downloadMyspaceFiles()
        {
            workspacePage.downloadFilesFromMySpace();
        }


        @Test(priority = 4, groups = {"workspace"})
        public void makeMyspaceFilesPublic()
        {
            workspacePage.makeMyspaceFilePublic();
        }


        @Test(priority = 5, groups = {"workspace"})
        public void downloadFilesFromCommunity()
        {
            workspacePage.navigateToCommunity();
            workspacePage.downloadFilesFromCommunity();

        }


        @Test(priority = 7, groups = {"workspace"})
        public void deleteFilesFromMyspace()
        {
            workspacePage.deleteFilesFromMyspace();
        }


        @Test(priority = 6, groups = {"workspace"})
        public void copyFilesToMyspace()
        {
            workspacePage.copyFileFromCommunityToMyspace();

        }

        @AfterClass(alwaysRun = true)
        public void tearDown()
        {
           workspacePage.tearDown();
        }
}


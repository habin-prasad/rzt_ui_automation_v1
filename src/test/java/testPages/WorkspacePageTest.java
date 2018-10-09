package testPages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.WorkspacePage;
import pages.LoginPage;

import java.awt.*;
import java.util.concurrent.TimeUnit;

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
            try {
                workspacePage.uploadFiles();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }


        @Test(priority = 1, groups = {"workspace"})
        @Parameters({"pageTitle"})
        public void verifyTitle(String pageTitle)
        {
            workspacePage.verifyTitle(pageTitle);
        }


      //  @AfterClass(alwaysRun = true)
       // public void tearDown()
      //  {
     //       workspacePage.tearDown();
      //  }
}


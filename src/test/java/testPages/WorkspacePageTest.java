package testPages;

import base.BaseClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WorkspacePage;

import java.util.concurrent.TimeUnit;

public class WorkspacePageTest extends BaseClass {



    @BeforeClass
    public void launchBrowser(){
        BaseClass baseClass= new BaseClass();

        baseClass.launchSetUp();
    }


    @Test
    public void loginPageTest() {
        WorkspacePage workspacePage = new WorkspacePage(driver);
        workspacePage.Upload();
    }


        @AfterClass
        public void tearDown(){
            driver.close();
        }
}


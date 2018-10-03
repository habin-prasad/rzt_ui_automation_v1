package testPages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WorkspacePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WorkspacePageTest extends LoginPage {

        WebDriver driver;

    public WorkspacePageTest(String webDriver) {

        super();
    }


   // @BeforeClass
       // public void launchBrowser(){

        //login("kajal.kiran@razorthink.com", "1");

       // }


        @Test
        public void fileUploadTest()
        {
            WorkspacePage ws=new WorkspacePage(driver);
            ws.uploadFiles();
        }


        @AfterClass
        public void tearDown()
        {
        driver.close();
        }
}


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

public class WorkspacePageTest extends BaseClass {

        WebDriver driver;
        static LoginPage login;


        @BeforeClass
        public void launchBrowser(){
            launchSetUp();
            LoginPage lp =new LoginPage(driver);
            lp.loginForExistingUser();
        }


        @Test
        public void fileUploadTest() {
            WorkspacePage ws=new WorkspacePage(driver);
            ws.uploadFiles();
        }


        @AfterClass
        public void tearDown(){
        driver.close();
        }
}


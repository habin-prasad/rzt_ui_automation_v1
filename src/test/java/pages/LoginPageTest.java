package pages;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ExcelFileModifier;
import utils.Validations;

/**
 * author: habin,
 * created on: 25/09/18 : 6:30 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class LoginPageTest {
    private LoginPage loginPage;
    private Validations validations = new Validations();

    @BeforeGroups(alwaysRun = true, groups = {"loginP"})
    public void settingUp() {
        loginPage = new LoginPage();
    }

/*.
    @Test(groups = {"loginP"}, priority = 2)
    @Parameters({"loginTitle"})
    public void validatePTitle(String title) {
//        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
        loginPage.verifyTitle(title);

    }*/

    @Test(groups = {"loginP"}, priority = 1)
    @Parameters({"username", "password"})
    public void login(String username, String password) {
        loginPage.login(username, password);
//        validations.validateTitle(title, loginPage.returnTitle(), loginPage.driver);
    }

    @AfterGroups(alwaysRun = true, groups = {"loginP"})
    public void tearDown() {

        loginPage.driver.quit();
    }

    @Test(groups = {"loginP"},priority = 3)
    public void verifyPageTitle()
    {
        String expectedResult= "Razorthink AI";

        System.out.println(loginPage.getMethodName());
        if (expectedResult.equalsIgnoreCase(loginPage.returnTitle())) {
            boolean result=true;
            ExcelFileModifier.updateResultColumn(result,loginPage.getMethodName());
        }
        else
            {
            boolean result=false;
            ExcelFileModifier.updateResultColumn(result,loginPage.getMethodName());
        }
    }

    @Test(groups = {"loginP"},priority = 4)
    public void verifyPageTitle2()
    {
        String expectedResult= "Razorthinkff AI";
        String testcase=loginPage.getMethodName();
        System.out.println(testcase);
        if (expectedResult.equalsIgnoreCase(loginPage.returnTitle())) {
            boolean result=true;
            System.out.println(result);
            ExcelFileModifier.updateResultColumn(result,loginPage.getMethodName());
        }

        else
        {
            boolean result=false;
            ExcelFileModifier.updateResultColumn(result,loginPage.getMethodName());
        }
    }
}

package pages.admin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * author: habin,
 * created on: 19/11/18 : 11:40 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class OpenRequestsTest {

    private OpenRequests openRequests;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void settingUp(String userName, String password) {
        openRequests = new OpenRequests(userName, password);
        openRequests.clickOpenRequests();
    }

    @Test(priority = 201, groups = "openRequest")
    @Parameters({"userEmail2"})
    public void acceptUserRequest(String email) {
        openRequests.acceptOpenRequest(email);
    }

    @Test(priority = 202, groups = "openRequest")
    @Parameters({"userEmail2"})
    public void cancelUserRequest(String email) {
        openRequests.cancelOpenRequest(email);
    }


    @AfterClass(alwaysRun = true, groups = "openRequests")
    public void tearDown() {
        openRequests.tearDown();
    }
}
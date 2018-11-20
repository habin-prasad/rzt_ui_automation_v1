package pages.admin;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by rukhaiya on 11/15/18.
 */
public class UserTest {

    private  Users users;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void Users(String username, String password) {
        users = new Users(username, password);
    }

    @Test(priority = 921,groups = "settings1")
    @Parameters({"username","assign_role"})
    public void FindUser(String username,String assign_role) throws InterruptedException {
        users.assignRole(username,assign_role);
    }

    @AfterGroups(alwaysRun = true, groups = "settings1")
    public void tearDown() {
        users.driver.quit();
    }
}

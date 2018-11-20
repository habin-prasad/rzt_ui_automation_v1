package pages.admin;

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

    @Test(priority = 921,groups = "settings")
    @Parameters({"username"})
    public void FindUser(String username){
        users.getUserName(username);
    }

}

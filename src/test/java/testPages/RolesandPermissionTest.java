package testPages;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RoleAndPermissions;

/**
 * author: habin,
 * created on: 03/10/18 : 5:10 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class RolesandPermissionTest {
    private RoleAndPermissions roleAndPermissions;
    private String roleName;
    private Faker faker = new Faker();

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void navigateToRolesPage(String username, String password) {
        roleAndPermissions = new RoleAndPermissions(username, password);
        roleAndPermissions.clickRolesTab();
        roleName = faker.name().firstName();
    }

    @Test(groups = {"settings"}, priority = 1)
    public void addNewUser() {
        roleAndPermissions.addNewRole(roleName);
    }

    @Test(groups = {"settings"},enabled = true)
    public void verifyIfUserAdded() {

        roleAndPermissions.ifUserRoleAdded(roleName);
    }

    @AfterGroups(alwaysRun = true, groups = {"settings"})
    public void tearDown() {

        roleAndPermissions.driver.quit();
    }
}

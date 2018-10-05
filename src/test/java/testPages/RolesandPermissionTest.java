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

    @Test(priority = 901,groups = "roles_permissions",enabled = false)
    public void addNewUser() {
        roleAndPermissions.addNewRole(roleName);
    }

    @Test(priority = 902,groups = "roles_permissions",enabled = false)
    public void verifyIfUserAdded() {
        roleAndPermissions.ifUserRoleAdded(roleName);
    }

    @Test(priority = 903,groups = "roles_permissions",enabled = false)
    public void copyUserRole(){
        roleAndPermissions.copyRole(roleName);
    }

    @Test(priority = 904,groups = "roles_permissions",enabled = false)
    public void verifyIfRoleCopied(){
        roleAndPermissions.ifRoleCopied(roleName);
    }

    @Test(priority = 905,groups = "roles_permissions",enabled = false)
    public void deleteRoleTest(){
        roleAndPermissions.deleteRole(roleName+" copy 1");
    }

    @Test(priority = 906,groups = "roles_permissions",enabled = false)
    public void verifyIfDeleted(){
        roleAndPermissions.ifUserRoleDeleted(roleName+" copy 1");
    }

    @Test(priority = 999,groups = "roles_permissions",enabled = false)
    public void logoutTest(){
        roleAndPermissions.logout();
    }

    @Test(priority = 1000,groups = "roles_permissions")
    public void deleteAllRoles(){
        roleAndPermissions.deleteAllRoles();
    }

    @AfterGroups(groups = "roles_permissions",enabled = true)
    public void tearDown(){
        roleAndPermissions.logout();
        roleAndPermissions.tearDown();

    }



}

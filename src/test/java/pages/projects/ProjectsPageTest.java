package pages.projects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author: habin,
 * created on: 13/11/18 : 5:31 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ProjectsPageTest {

    ProjectsPage projectsPage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void navigateToProjectsPage(String username, String password) {
        projectsPage = new ProjectsPage(username, password);
    }

    @Test
    public void navigate() {

    }

    @AfterMethod
    public void tearDown() {
    }
}
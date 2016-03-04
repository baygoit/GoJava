package ua.dborisenko.kickstarter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DataSourceProjectTest {

    private static Project project = new Project();
    
    @Before
    public void prepareDataSource() {
        DataSource.allProjects.clear();
        DataSource.allProjectCategories.clear();
        project.setId(1);
    }
    
    @Test
    public void addTest() {
        DataSourceProject.add(project);
        boolean isProjectExists = false;
        for (Project currentProject : DataSource.allProjects) {
            if (currentProject.getId() == 1) {
                isProjectExists = true;
                break;
            }
        }
        assertTrue(isProjectExists);
    }

    @Test
    public void updateTest() {
        DataSourceProject.add(project);
        Project changedProject = new Project();
        changedProject.setId(project.getId());
        changedProject.setName("testname");
        DataSourceProject.update(changedProject);
        boolean isProjectExists = false;
        for (Project currentProject : DataSource.allProjects) {
            if (currentProject.getName().equals("testname")) {
                isProjectExists = true;
                break;
            }
        }
        assertTrue(isProjectExists);
    }
    
    @Test
    public void deleteTest() {
        DataSourceProject.add(project);
        DataSourceProject.delete(project);
        for (Project currentProject : DataSource.allProjects) {
            if (1 == currentProject.getId()) {
                fail("Project is still exists.");
            }
        }
    }
    
    @Test
    public void getProjectsByCategoryIdTest() {
        ProjectCategory category = new ProjectCategory();
        category.setId(1);
        category.setName("test category");
        project.setCategory(category);
        DataSourceProject.add(project);
        assertTrue(1 == DataSourceProject.getProjectsByCategoryId(1).size());
    }
}

package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-db.xml",
"classpath:applicationContext.xml"})
@Transactional
public class ProjectDaoIntegrationTest {

    @Autowired
    private ProjectDao projectDao;


    @Test
    public void testGetAll(){
        List<Project> projects = projectDao.getAll();
        assertThat(projects.isEmpty(),is(false));
    }
    
    @Test
    public void testGetProjectByName(){
        final String name = "SuperMario 3D";
        Project project = projectDao.getProjectByName(name);
        assertThat(project.getProjectName().equals(name),is(true));
    }
    
    
    @Test
    public void testGetProjectsByCategoryId(){
        assertThat(projectDao.getProjectsByCategoryId(1).size(), is(1));
    }
 
}

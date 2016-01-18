package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava7.kickstarter.dao.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class ProjectPostgreDAOTest  implements IntegrationTest{

    List<Project> list;
    
    @Autowired
    ProjectPostgreDAO projectPostgreDAO;
    
	@Autowired
    CategoryPostgreDAO categoryPostgreDAO;

	private List<Category> categories;

    @Before
    public void setUp() throws Exception {
    	categories = categoryPostgreDAO.getAll();
    	
    	projectPostgreDAO.clear();   	
        list = new ArrayList<>();
        list.add(new Project(1, "p1", "a1", categories.get(0)));
        list.add(new Project(2, "p2", "a2", categories.get(0)));
        list.add(new Project(3, "p3", "a3", categories.get(1)));
        projectPostgreDAO.addAll(list);
    }

    @Test
    public void testAddGetAll() {
        assertThat(projectPostgreDAO.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        Project project = list.get(1);
        list.forEach(projectPostgreDAO::add);
        assertThat(projectPostgreDAO.get(project.getId()), is(project));
    }

    @Test
    public void testGetByCategory() {
        projectPostgreDAO.addAll(list);
        int catId = categories.get(0).getId();
        projectPostgreDAO.getByCategory(catId).forEach(p -> assertThat(p.getCategory().getId(), is(catId)));
    }

}

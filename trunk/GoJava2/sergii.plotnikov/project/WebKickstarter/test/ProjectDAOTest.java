import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Project;
import com.goit.kickstarter.service.DBConnection;
import com.goit.kickstarter.service.ProjectService;

public class ProjectDAOTest {
	DBConnection conn = new DBConnection();
	ProjectDAO projDao;
	
	@Before
	public void clean() throws SQLException{
		projDao=new ProjectDAO(conn.getConnection());
		projDao.deleteProject("new project");
		
		Project p = new Project("test_project", "aaaa", 123);
		projDao.updateProject(p);
	}
	
	@Test
	public void shouldBeNotNull_whenDaoGetProject() {
		Project p = projDao.getProject(1);
		assertNotNull(p);
	}
		
	@Test
	public void shouldCreateProject_whenDaoCreateProject() {
		Project p = new Project("new project", "this is a description", 999);
		int lengthBefore = projDao.getLength("");
		
		projDao.createProject(p);
		int lengthAfter = projDao.getLength("");
		
		assertEquals(lengthBefore+1, lengthAfter);
	}
	
	@Test
	public void shouldDeleteProject_whenDaoDeleteProject() {
		Project p = new Project("new project", "this is a description", 999);
		projDao.createProject(p);
		int lengthBefore = projDao.getLength("");
		
		projDao.deleteProject("new project");
		int lengthAfter = projDao.getLength("");
		
		assertEquals(lengthBefore-1, lengthAfter);
	}	
	
	@Test
	public void shouldGetProject_whenDaoGetProject(){
		Project test = new Project("Football", "this is a short description", 10000);
		Project p = projDao.getProject(2);
		
		assertEquals(test, p);
	}
	
	@Test
	public void shouldUpdateProject_whenDaoUpdateProject() {				
		Project p1 = new Project("test_project", "bbbb", 555);
		
		projDao.updateProject(p1);
		
		Project p = projDao.getProject(4);
		
		assertEquals(p1, p);
	}
	
	@Test
	public void shouldPrintProject() throws SQLException{
		ProjectService service = new ProjectService(conn.getConnection());
		String test = "test_project\naaaa\nPrice: 123";
		assertEquals(test, service.project(projDao.getProject(4)));
	}
}
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.sql.SQLException;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//
//import com.goit.kickstarter.dao.ProjectDAO;
//import com.goit.kickstarter.model.Project;
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
//
//public class ProjectDAOTest {
//	@Autowired
//	ProjectDAO projectDao;
//	
//	@Before
//	public void clean() throws SQLException{
//		projectDao.deleteProject("new project");
//		
//		Project p = new Project("test_project", "aaaa", 123);
//		projectDao.updateProject(p);
//	}
//	
//	@Test
//	public void shouldBeNotNull_whenDaoGetProject() {
//		Project p = projectDao.getProject(1);
//		assertNotNull(p);
//	}
//		
//	@Test
//	public void shouldCreateProject_whenDaoCreateProject() {
//		Project p = new Project("new project", "this is a description", 999);
//		int lengthBefore = projectDao.getLength();
//		
//		projectDao.createProject(p);
//		int lengthAfter = projectDao.getLength();
//		
//		assertEquals(lengthBefore+1, lengthAfter);
//	}
//	
//	@Test
//	public void shouldDeleteProject_whenDaoDeleteProject() {
//		Project p = new Project("new project", "this is a description", 999);
//		projectDao.createProject(p);
//		int lengthBefore = projectDao.getLength();
//		
//		projectDao.deleteProject("new project");
//		int lengthAfter = projectDao.getLength();
//		
//		assertEquals(lengthBefore-1, lengthAfter);
//	}	
//	
//	@Test
//	public void shouldGetProject_whenDaoGetProject(){
//		Project test = new Project("Football", "this is a short description", 10000);
//		Project p = projectDao.getProject(2);
//		
//		assertEquals(test, p);
//	}
//	
//	@Test
//	public void shouldUpdateProject_whenDaoUpdateProject() {				
//		Project p1 = new Project("test_project", "bbbb", 555);
//		
//		projectDao.updateProject(p1);
//		
//		Project p = projectDao.getProject(4);
//		
//		assertEquals(p1, p);
//	}
//}
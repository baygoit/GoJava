package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.DAO.ProjectDAO;
import ua.com.goit.gojava.kickstarter.Model.Category;
import ua.com.goit.gojava.kickstarter.Model.Project;



public class ProjectDaoTest {

	/*static ProjectDAO projectDao = new ProjectDAO();
	static Category education = new Category("education", 1);
	static int lastIndexBefore = projectDao.getListProjectByCategoryId(education.getId()).size();
	static Project project = new Project("TestProject", 999, "OnlyTestProject", 100, 10, 30, 
			"No History", "www.kuku.com", education, null);

	@Test
	public void testCreateProject() {
		projectDao.createProject(project);
		int lastIndex = projectDao.getListProjectByCategoryId(education.getId()).size();
		Project proj = projectDao.getListProjectByCategoryId(education.getId()).get(lastIndex-1);
		assertEquals(project.getName(),proj.getName());
	}
*/
	/*@Test
	public void testUpdateProjectHaveMoney() {
		project.addMoney(40); 
		projectDao.updateProjectHaveMoney(project);
		int lastIndex = projectDao.getListProjectByCategoryId(education.getId()).size() - 1;
		Project proj = projectDao.getListProjectByCategoryId(education.getId()).get(lastIndex);
		assertEquals(project,proj );
	}*/
	
	/*@AfterClass
	public static void testDeleteProject() {
		projectDao.deleteProject(project);
		int lastIndexAfter = projectDao.getListProjectByCategoryId(education.getId()).size();
		assertEquals(lastIndexBefore, lastIndexAfter);
	}
	*/
}

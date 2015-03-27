import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		CategoriesDAO caegoriesDAO = context.getBean(CategoriesDAO.class);
		ProjectsDAO projectsDAO = context.getBean(ProjectsDAO.class);
		
		List<Category> categories = caegoriesDAO.getCategories();
		Category category = categories.get(1);
//		Project project = new Project(category);
//		project.setName("World hitting");
//		project.setCategoryId(category.getId());
//		projectsDAO.add(project);
		
		List<Project> projects = category.getProjects();
		
		System.out.println(categories.toString());
		System.out.println(projects.toString());
	}
}

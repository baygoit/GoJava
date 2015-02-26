package ua.goit.goitjava.kickstarter.DB;

import java.util.List;

public class Controller {
	
	CategoriesDAO cat = new CategoriesDAO();
	ProjectDAO projDao = new ProjectDAO();
	View view = new View();

	public void showProjectByID(int id) {
		Project p = projDao.getProjectByID(id);
		view.printSelectProject(p);
	}

	public void showProjectByCategory(int categoryId) {
		view.printProject(projDao.getListProjectByCategoryId(categoryId));
	}
	
	public List<Project> getProjectByCategoryId(int categoryId){
		return projDao.getListProjectByCategoryId(categoryId);
	}
	
	public Project getSelectProgect(int num, int categoryId){
		Project project = projDao.getListProjectByCategoryId(categoryId).get(num - 1);
		return project;
	}
	
	public void showAllCategories() {
		view.printAllCategories(cat.getAllCategories());
	}

	public void showCategoryByID(int id) {
		view.printSelectCategory(cat.getSelectCategory(id));
	}

	public void updateProject(Project project) {
		projDao.updateProjectHaveMoney(project);		
	}
}
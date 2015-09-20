package goit.nz.kickstarter.action;

import goit.nz.kickstarter.model.CategoryModel;
import goit.nz.kickstarter.service.CategoryService;
import goit.nz.kickstarter.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

public class CategoryAction implements Action {
	private CategoryModel model;
	private CategoryService categorySevice;
	private ProjectService projectService;
	private final String VIEW = "category";

	public void setCategoryService(CategoryService categoryService) {
		this.categorySevice = categoryService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		long categoryId = Long.parseLong(request.getParameter("id"));
		model = new CategoryModel();
		model.setCategory(categorySevice.getCategory(categoryId));
		model.setProjects(projectService.getProjects(categoryId));
		request.setAttribute("model", model);
		return VIEW;
	}

}

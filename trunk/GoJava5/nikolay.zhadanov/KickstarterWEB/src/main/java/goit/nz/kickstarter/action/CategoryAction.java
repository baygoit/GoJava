package goit.nz.kickstarter.action;

import goit.nz.kickstarter.service.CategoryService;
import goit.nz.kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "**/category")
public class CategoryAction {
	private CategoryService categorySevice;
	private ProjectService projectService;
	private static final String VIEW = "category";

	public void setCategoryService(CategoryService categoryService) {
		this.categorySevice = categoryService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "{categoryId}", method = RequestMethod.GET)
	public ModelAndView execute(@PathVariable("categoryId") long categoryId) {
		ModelAndView model = new ModelAndView();
		model.addObject("category", categorySevice.getCategory(categoryId));
		model.addObject("projects", projectService.getProjects(categoryId));
		model.setViewName(VIEW);
		return model;
	}

}

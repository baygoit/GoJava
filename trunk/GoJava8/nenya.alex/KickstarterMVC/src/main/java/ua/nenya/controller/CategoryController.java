package ua.nenya.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

@Controller
public class CategoryController {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String showCategory (@PathVariable Long categoryId, Map<String, Object> model){
		if(!categoryDao.isCategoryExist(categoryId)){
			model.put("categoryId", categoryId);
			model.put("categoryTestId", -1);
			return "404";
		}
		model.put("categoryId", categoryId);
		List<Project> projects = projectDao.getProjectsByCategoryId(categoryId);
		model.put("projects", projects);
		return "category";
	}

}

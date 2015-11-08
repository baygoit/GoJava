package ua.com.goit.gojava.kickstarter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.goit.gojava.kickstarter.DAO.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.DAO.ProjectDAO;
import ua.com.goit.gojava.kickstarter.Model.Category;
import ua.com.goit.gojava.kickstarter.Model.Project;

@Controller
public class RestController {
		@Autowired
		private CategoriesDAO categoriesDao;
		
		@Autowired
		private ProjectDAO projectDao;
		
		@RequestMapping(value = "/")
		public String getMainPage() {
			return "main";
		}
		
		@RequestMapping(value = "/categories")
		public @ResponseBody List<Category> getCategories() {
			return categoriesDao.getAllCategories();
		} 
		
		@RequestMapping(value = "/categories/{id}")
		public @ResponseBody Category getCategory(@PathVariable int id) {
			return categoriesDao.getSelectCategory(id);
		} 
		
		@RequestMapping(value = "/categories/{categoryId}/projects")
		public @ResponseBody List<Project> getProjects(@PathVariable int categoryId) {
			Category category = categoriesDao.getSelectCategory(categoryId);
			return projectDao.getProjects(category);
		} 
		
		@RequestMapping(value = "/projects/{id}")
		public @ResponseBody Project getProject(@PathVariable int id) {
			return projectDao.getProject(id);
		} 
}





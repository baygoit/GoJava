package ua.nenya.controller.jsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Project;

@Controller
public class CategoryController {
	
	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String showCategory(@PathVariable Long categoryId, Map<String, Object> model) {
		if (!categoryDao.isCategoryExistById(categoryId)) {
			logger.error("Category with id "+categoryId+" dosen't exist!");
			model.put("categoryId", categoryId);
			model.put("categoryTestId", -1);
			return "404Page";
		}
		
		model.put("quote", quoteDao.getRandomQuote());
		
		List<Project> projects = getProjectsWithAvailableAmount(projectDao.getProjectsByCategoryId(categoryId));
		
		model.put("projects", projects);
		
		model.put("categoryId", categoryId);
		return "categoryPage";
	}

	private List<Project> getProjectsWithAvailableAmount(List<Project> projects) {
		List<Project> resultProjects = new ArrayList<>();
		for(Project it: projects){
			long sum = projectDao.getPaymentSum(it.getId());
			it.setAvailableAmount(sum);
			resultProjects.add(it);
		}
		return resultProjects;
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
		logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex);
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
         
        modelAndView.setViewName("errorPage");
        return modelAndView;
	}
}

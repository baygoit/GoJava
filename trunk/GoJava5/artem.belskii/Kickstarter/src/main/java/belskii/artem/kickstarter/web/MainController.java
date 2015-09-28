package belskii.artem.kickstarter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.controller.CategoryController;
import belskii.artem.kickstarter.mvc.controller.ProjectController;
import belskii.artem.kickstarter.mvc.controller.QuoteController;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.model.QuoteModel;


@Controller
public class MainController {
	private CategoryController category = new CategoryController(new CategoryModel());
	private ProjectController project = new ProjectController(new ProjectModel());
	private QuoteController quote = new QuoteController(new QuoteModel());
	private String serverRoot = "Kickstarter";
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("quote", quote.getRandomQuote());
        model.addAttribute("categories", category.getCategoryList().values());
        return "mainPage";
    }
    
    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public ModelAndView projectFromCategories(@PathVariable(value = "categoryId") int categoryId) {
    	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category");
		modelAndView.addObject("projectList",project.getProjectFromCategory(categoryId).values());
		modelAndView.addObject("currentCategory", category.getCategoryList().get(categoryId));
		modelAndView.addObject("currentCategoryId",categoryId);
		modelAndView.addObject("serverRoot", serverRoot);
        return modelAndView;
    }
    
    @RequestMapping(value = "/category/{categoryId}/project/{projectId}", method = RequestMethod.GET)
    public ModelAndView projectDetails(@PathVariable(value = "projectId") int projectId, @PathVariable(value = "categoryId") int categoryId) {
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("projectDetails");
		modelAndView.addObject("project", project.getProjectById(projectId));
		modelAndView.addObject("paymetVariants", project.getProjectById(projectId).getPaymetVariants());
		modelAndView.addObject("currentCategoryId",categoryId);
        return modelAndView;
    }
    
    @RequestMapping(value = "/category/{categoryId}/project/{projectId}", method = RequestMethod.POST)
    public ModelAndView updateProject(@ModelAttribute("question") String question, 
    								@ModelAttribute("donate") String donate, 
    								@ModelAttribute("customDonate") String customDonate,
    								@PathVariable(value = "projectId") int projectId,
    								@PathVariable(value = "categoryId") int categoryId){
    	Project projectForUpdate=project.getProjectById(projectId);
    	if (!question.equals("")){
    		projectForUpdate.asqAQuestion(question);
    	}
    	if (!donate.equals("") || !customDonate.equals("")){
    		Long customDonateL=0L;
    		Long donateL=0L;
    		if (!customDonate.equals("")){customDonateL = Long.valueOf(customDonate);}
    		if (!donate.equals("")){donateL = Long.valueOf(customDonate);}
    		
    		if (customDonateL>0){
    			projectForUpdate.updateBalance(customDonateL);
    		} else {
    			System.out.println(donateL);    			
    			projectForUpdate.updateBalance(donateL);
    		}
    	}
    	project.save(projectForUpdate);

    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("projectDetails");
		modelAndView.addObject("project", projectForUpdate);
		modelAndView.addObject("paymetVariants", projectForUpdate.getPaymetVariants());
		modelAndView.addObject("currentCategoryId",categoryId);
		
    	return modelAndView;
    }
}
package kickstarter.web;

import kickstarter.manager.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String categories(ModelMap model) {
		
		Manager operator = new Manager ();

		model.addAttribute("categories", operator.getAllCategories());
		return "Categories";
		
	}

}
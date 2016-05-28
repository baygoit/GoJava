package kickstarter.web;

import java.util.HashMap;




import kickstarter.manager.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



	@Controller
	//@RequestMapping("/type/{type}")
	public class TypeController {
		
	
		@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
		public String openTypeController(@PathVariable("type") String type, ModelMap model) {
			
			Manager operator = new Manager ();
		//	String type = request.getQueryString();
	
			HashMap<Integer, String> projects = operator
					.getAllProjectsByCategory(type);
			
			model.addAttribute("type", type);
			model.addAttribute("projects", projects);
			
			return "Type";
			
		}
}

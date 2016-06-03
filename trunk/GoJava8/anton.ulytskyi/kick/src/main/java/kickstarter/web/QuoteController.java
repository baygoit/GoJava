package kickstarter.web;

import kickstarter.manager.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class QuoteController {

	@RequestMapping(method = RequestMethod.GET)
	public String showQuote(ModelMap model) {

		Manager operator = new Manager();

		model.addAttribute("quote", operator.getRandomQuote());
		return "Quote";

	}

}

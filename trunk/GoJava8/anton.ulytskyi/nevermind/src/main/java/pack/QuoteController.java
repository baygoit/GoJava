package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


	 
	@Controller
	@RequestMapping("/")
	public class QuoteController {
	 
	  @Autowired private QuoteService quoteSvc;
	   
	  /**
	   * Requests to http://localhost:8080/hello will be mapped here.
	   * Everytime invoked, we pass list of all persons to view
	   */
	  @RequestMapping(method = RequestMethod.GET)
	  public String listAll(Model model) {
	    model.addAttribute("quote", quoteSvc.getAll());
	    return "home";
	  }
	   
	  /**
	   * POST requests to http://localhost:8080/hello/addPerson goes here.
	   * The new person data is passed from HTML from and bound into the
	   * Person object.
	   */
	  @RequestMapping(value = "/addQuote", method = RequestMethod.POST)
	  public String addQuote(@ModelAttribute Quote quote) {
	    quoteSvc.add(quote);
	    return "redirect:/";
	  }
	}

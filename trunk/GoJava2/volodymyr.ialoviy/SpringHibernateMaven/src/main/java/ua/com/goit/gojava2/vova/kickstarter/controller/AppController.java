package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Donation;
import ua.com.goit.gojava2.vova.kickstarter.model.Donator;
import ua.com.goit.gojava2.vova.kickstarter.model.Question;
import ua.com.goit.gojava2.vova.kickstarter.service.CategoryService;
import ua.com.goit.gojava2.vova.kickstarter.service.DonationService;
import ua.com.goit.gojava2.vova.kickstarter.service.DonatorService;
import ua.com.goit.gojava2.vova.kickstarter.service.ProjectService;
import ua.com.goit.gojava2.vova.kickstarter.service.QuestionService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProjectService projectService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	DonatorService donatorService;
	
	@Autowired
	DonationService donationService;

	@RequestMapping(value = {"/", "/categories"}, method = RequestMethod.GET)
	public String listCategories(ModelMap model, HttpServletRequest req) {
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("message", req.getParameter("message"));
		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String showCategory(ModelMap model, @PathVariable int id) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "category";
	}

	@RequestMapping(value = "/categories/{id}", params = "delete", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @PathVariable int id) {
		if (categoryService.getCategoryById(id).getProjects().isEmpty()){
			categoryService.deleteCategoryById(id);
			model.addAttribute("message", "Category successfully deleted");
		} else {
			model.addAttribute("message", "This category can not be removed because it is still not empty");
		}
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/categories", params = "add", method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addcategory";
	}

	@RequestMapping(value = "/categories", params = "add", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addcategory";
		}
		categoryService.saveCategory(category);
		model.addAttribute("message", "Category registered successfully");
		return "redirect:/categories";
	}

	@RequestMapping(value = "/question/{id}", params = "add", method = RequestMethod.GET)
	public String newQuestion(ModelMap model, @PathVariable int id) {
		Question question = new Question();
		model.addAttribute("id", id);
		model.addAttribute("question", question);
		return "addquestion";
	}

	@RequestMapping(value = "/question/{id}", params = "add", method = RequestMethod.POST)
	public String saveQuestion(@Valid Question question, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
			return "addquestion";
		}
		questionService.saveQuestion(question);
		model.addAttribute("message", "Question added successfully");
		return "redirect:/projects/" + id + "?show";
	}
	
	@RequestMapping(value = "/question/{id}/{idProject}", params = "delete", method = RequestMethod.GET)
	public String deleteQuestion(ModelMap model, @PathVariable int id) {
		questionService.deleteQuestionById(id);
		model.addAttribute("message", "Question deleted successfully");
		return "redirect:/projects/{idProject}?show";
	}
	
	@RequestMapping(value = "/question/{id}", params = "addanswer", method = RequestMethod.GET)
	public String newAnswer(ModelMap model, @PathVariable int id) {
		Question question = questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "addanswer";
	}

	@RequestMapping(value = "/question/{id}", params = "addanswer", method = RequestMethod.POST)
	public String saveAnswer(ModelMap model, @PathVariable int id, HttpServletRequest req) {
		String red = "redirect:/projects/" + questionService.getQuestion(id).getIdProject() + "?show";
		if (!(questionService.getQuestion(id).getAnswer() == null)) {
			model.addAttribute("message", "Answer for this question already exist");
			return red;
		}
		questionService.addAnswer(req.getParameter("answer"), id);
		model.addAttribute("message", "Answer added successfully");
		return red;
	}
	
	@RequestMapping(value = "/donate/{id}", method = RequestMethod.GET)
	public String donate(ModelMap model, @PathVariable int id) {
		model.addAttribute("id", id);
		return "donate";
	}

	@RequestMapping(value = "/adddonate/{idProject}/{amount}", method = RequestMethod.GET)
	public String showDonationChoice(ModelMap model, @PathVariable int idProject, @PathVariable int amount) {
		return "adddonate";
	}
	
	@RequestMapping(value = "/adddonate/{idProject}/{amount}", method = RequestMethod.POST)
	public String saveDonate(ModelMap model, @PathVariable int idProject, HttpServletRequest req) {
		int amount = Integer.parseInt(req.getParameter("amount"));
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		long card = Long.valueOf(req.getParameter("card")).longValue();
		
		Donator donator = new Donator(name, mail, card);
		donatorService.saveDonator(donator);
		
		Donation donation = new Donation(donator.getId(), idProject, amount);
		donationService.saveDonation(donation);
		
		model.addAttribute("idProject", idProject);
		projectService.addDonate(amount, idProject);
		model.addAttribute("message", "Donate " + amount + " successfully");
		return "redirect:/projects/{idProject}?show";
	}
}

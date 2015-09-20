package ua.com.goit.gojava2.vova.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava2.vova.kickstarter.model.Question;
import ua.com.goit.gojava2.vova.kickstarter.service.QuestionService;

@Controller
@RequestMapping("/")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
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
}

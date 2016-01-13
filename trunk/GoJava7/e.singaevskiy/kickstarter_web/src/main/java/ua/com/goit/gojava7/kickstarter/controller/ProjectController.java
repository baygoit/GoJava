package ua.com.goit.gojava7.kickstarter.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Controller
public class ProjectController {

	@Autowired
	private RewardDAO rewardDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private PaymentDAO paymentDAO;

	@Autowired
	private QuestionsDAO questionsDAO;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView showProject(@RequestParam(name = "id") Integer projectId) {

		ModelAndView modelAndView = new ModelAndView("projectDetails");
		modelAndView.addObject("project", projectDAO.get(projectId));
		modelAndView.addObject("rewards", rewardDAO.getByProject(projectId));
		return modelAndView;
	}

	@RequestMapping("/message")
	public ModelAndView showRequestMessage(@RequestParam(name = "id") Integer projectId) {
		ModelAndView modelAndView = new ModelAndView("message");
		modelAndView.addObject("projectId", projectId);
		return modelAndView;
	}

	@RequestMapping("/payment")
	public ModelAndView showRequestPayment(@RequestParam Integer projectId, @RequestParam Integer rewardId) {

		ModelAndView modelAndView = new ModelAndView("payment");
		modelAndView.addObject("projectId", projectId);

		Reward reward = rewardDAO.get(rewardId);
		if (reward != null) {
			modelAndView.addObject("amount", reward.getPledgeSum());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String processOperation(Model model, HttpServletRequest request) {

		String operation = request.getParameter("operation");

		if (operation.equals("message")) {
			return processMessage(model, request);
		} else if (operation.equals("payment")) {
			return processPayment(model, request);
		}

		return "redirect:/";
	}

	private String processMessage(Model model, HttpServletRequest request) {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String user = request.getParameter("user");
        String message = request.getParameter("message");

		Map<String, String> validationErrors = validateMessage(user, message);
		
		model.addAttribute("id", projectId);

		if (validationErrors.isEmpty()) {
			questionsDAO.add(new Question(projectDAO.get(projectId), message, ""));
			return "redirect:/project";
		} else {
			request.getSession(false).setAttribute("errors", validationErrors);
			return "redirect:/message";
		}

	}

	private String processPayment(Model model, HttpServletRequest request) {

    	String projectId = request.getParameter("projectId");
    	String user = request.getParameter("user");
    	String rewardId = request.getParameter("rewardId");
    	String cardId = request.getParameter("cardId");
    	String amount = request.getParameter("amount");

		Map<String, String> validationErrors = validatePayment(user, cardId, amount);

		if (validationErrors.isEmpty()) {
			Payment payment = new Payment(projectDAO.get(Integer.parseInt(projectId)), rewardDAO.get(Integer.parseInt(rewardId)), user,
					Long.parseLong(cardId), Integer.parseInt(amount), new Date(System.currentTimeMillis()));
			paymentDAO.add(payment);
			model.addAttribute("id", projectId);
			return "redirect:/project";
		} else {
			request.getSession(false).setAttribute("errors", validationErrors);
			model.addAttribute("projectId", projectId);
			model.addAttribute("rewardId", rewardId);
			model.addAttribute("amount", amount);
			return "redirect:/payment";
		}

	}

	private Map<String, String> validatePayment(String user, String cardId, String amount) {
		Map<String, String> validationErrors = new HashMap<>();
		int nameLength = 3;
		if (user.length() < nameLength) {
			validationErrors.put("user", "User name must have at least " + nameLength + " characters length");
		}
		int cardLength = 9;
		if (!cardId.matches("[0-9]{" + cardLength + "}")) {
			validationErrors.put("cardId", "Card ID must be positive numeric and have at least " + cardLength + " characters length");
		}
		if (!amount.matches("[0-9]+") || Integer.valueOf(amount) <= 0) {
			validationErrors.put("amount", "Amount must be positive numeric");
		}
		return validationErrors;
	}

	private Map<String, String> validateMessage(String user, String message) {
		Map<String, String> validationErrors = new HashMap<>();
		int nameLength = 3;
		if (user.length() < nameLength) {
			validationErrors.put("user", "User name must have at least " + nameLength + " characters length");
		}
		int messageLength = 10;
		if (message.length() < messageLength) {
			validationErrors.put("message", "Message text must have at least " + messageLength + " characters length");
		}

		return validationErrors;
	}

}

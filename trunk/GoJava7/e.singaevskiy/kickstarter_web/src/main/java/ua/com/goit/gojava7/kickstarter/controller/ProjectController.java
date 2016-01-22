package ua.com.goit.gojava7.kickstarter.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.com.goit.gojava7.kickstarter.datasource.contract.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.datasource.contract.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.datasource.contract.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.datasource.contract.RewardDAO;
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
	public ModelAndView showProject(@RequestParam(name = "id") Long projectId) {

		ModelAndView modelAndView = new ModelAndView("projectDetails");
		modelAndView.addObject("project", projectDAO.get(projectId));
		modelAndView.addObject("rewards", rewardDAO.getByProject(projectId));
		return modelAndView;
	}

	@RequestMapping("/message")
	public String showRequestMessage(@RequestParam(name = "id") Long projectId, ModelMap model) {
		model.addAttribute("projectId", projectId);
		if (!model.containsAttribute("question")) {			
			model.addAttribute("question", new Question());
		}
		return "message";
	}

	@RequestMapping("/payment")
	public String showRequestPayment(@RequestParam Long projectId, @RequestParam Long rewardId, ModelMap model) {

		model.addAttribute("projectId", projectId);

		Reward reward = rewardDAO.get(rewardId);
		model.addAttribute("rewardId", rewardId != null ? rewardId : 0);
		model.addAttribute("amount", reward != null ? reward.getPledgeSum() : 0);		
		if (!model.containsAttribute("payment")) {			
			model.addAttribute("payment", new Payment());
		}
		return "payment";
	}
	
	@RequestMapping(value = "/submitmessage/{projectId}", method = RequestMethod.POST)
	public String submitMessage(@Valid Question question, BindingResult result,
			RedirectAttributes redirectAttributes, @PathVariable Long projectId) {
		
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.question", result);
			redirectAttributes.addFlashAttribute("question", question);
			return "redirect:/message?id=" + projectId;
		} else {
			question.setProject(projectDAO.get(projectId));
			questionsDAO.add(question);
			return "redirect:/project?id="+projectId;
		}

	}
	
	@RequestMapping(value = "/submitpayment/{projectId}/{rewardId}", method = RequestMethod.POST)
	public String submitPayment(@Valid Payment payment, BindingResult result,
			RedirectAttributes redirectAttributes,
			@PathVariable Long projectId, @PathVariable Long rewardId) {
		
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.payment", result);
			redirectAttributes.addFlashAttribute("payment", payment);
			return "redirect:/payment?projectId=" + projectId + "&rewardId=" + rewardId;
		} else {
			payment.setProject(projectDAO.get(projectId));
			payment.setReward(rewardDAO.get(rewardId));
			payment.setDate(new Date(System.currentTimeMillis()));
			paymentDAO.add(payment);
			return "redirect:/project?id="+projectId;
		}
	}

}

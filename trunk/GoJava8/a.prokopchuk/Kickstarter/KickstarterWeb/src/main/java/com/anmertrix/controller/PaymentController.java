package com.anmertrix.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

@Controller
public class PaymentController {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private RewardDao rewardDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private QuestionDao questionDao;

	@RequestMapping(value = "/project/{projectid}", method = RequestMethod.POST)
	public ModelAndView addPayment(@PathVariable Long projectid, @Valid @ModelAttribute("paymentForm") Payment paymentForm, BindingResult errors, Map<String, Object> model) {
		
		if (errors.hasErrors()) {
			Project project = projectDao.getProject(projectid);
			LocalDate finalDate = project.getFinalDate().toLocalDate();
			LocalDate today = LocalDate.now();
			if (today.isBefore(finalDate)) {
				project.setDaysLeft((int) ChronoUnit.DAYS.between(today, finalDate));
			}
			model.put("project", project);
			model.put("rewards", rewardDao.getRewards(projectid));
			model.put("payments", paymentDao.getPayments(projectid));
			model.put("questions", questionDao.getQuestions(projectid));
			model.put("questionForm", new Question());
			ModelAndView modelAndView = new ModelAndView("project");
			return modelAndView;
		}
		
		paymentForm.setProject(projectDao.getProject(projectid));
		
		ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectid);
        
		String cardHolderName = paymentForm.getCardholderName().trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		paymentForm.setCardholderName(cardHolderName);
		
		paymentDao.insertPayment(paymentForm);
		
        return modelAndView;
    }
	
	
}

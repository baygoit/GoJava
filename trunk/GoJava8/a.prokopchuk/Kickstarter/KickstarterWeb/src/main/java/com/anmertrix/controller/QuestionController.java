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
public class QuestionController {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private RewardDao rewardDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@RequestMapping(value = "/project/{projectId}/addQuestion", method = RequestMethod.POST)
	public ModelAndView addQuestion(@PathVariable Long projectId, @Valid @ModelAttribute("questionForm") Question questionForm, BindingResult errors, Map<String, Object> model) {
        
		if (errors.hasErrors()) {
			Project project = projectDao.getProject(projectId);
			LocalDate finalDate = project.getFinalDate().toLocalDate();
			LocalDate today = LocalDate.now();
			if (today.isBefore(finalDate)) {
				project.setDaysLeft((int) ChronoUnit.DAYS.between(today, finalDate));
			}
			model.put("project", project);
			model.put("rewards", rewardDao.getRewards(projectId));
			model.put("payments", paymentDao.getPayments(projectId));
			model.put("questions", questionDao.getQuestions(projectId));
			model.put("paymentForm", new Payment());
			ModelAndView modelAndView = new ModelAndView("project");
			return modelAndView;
		}
		
		questionForm.setProject(projectDao.getProject(projectId));
		
		ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectId);
		String questionText = questionForm.getQuestion().trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		questionForm.setQuestion(questionText);
        questionDao.insertQuestion(questionForm);
        
        return modelAndView;
    }
	
}

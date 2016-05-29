package com.anmertrix.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;

@Controller
public class ProjectController {

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
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String showProject(@PathVariable Long id, Map<String, Object> model) {
		if (!projectDao.isExists(id)) {
			return "404";
		}
		Project project = projectDao.getProject(id);
		LocalDate finalDate = project.getFinalDate().toLocalDate();
		LocalDate today = LocalDate.now();
		if (today.isBefore(finalDate)) {
			project.setDaysLeft((int) ChronoUnit.DAYS.between(today, finalDate));
		}
		model.put("project", project);
		model.put("rewards", rewardDao.getRewards(id));
		model.put("payments", paymentDao.getPayments(id));
		model.put("questions", questionDao.getQuestions(id));
		model.put("paymentForm", new Payment());
		
		return "project";
	}
	
}

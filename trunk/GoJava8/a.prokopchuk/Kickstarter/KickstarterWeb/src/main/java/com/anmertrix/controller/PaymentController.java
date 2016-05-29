package com.anmertrix.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

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
import com.anmertrix.validator.PaymentValidator;

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

	@RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
	public ModelAndView addPayment(@PathVariable Long id, @ModelAttribute("paymentForm") Payment paymentForm, BindingResult errors, Map<String, Object> model) {
		
		paymentForm.setProject(projectDao.getProject(id));
		
		ModelAndView modelAndView = new ModelAndView("redirect:/project/" + id);
        
		String cardHolderName = paymentForm.getCardholderName().trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		paymentForm.setCardholderName(cardHolderName);
		
		paymentDao.insertPayment(paymentForm);
		
        return modelAndView;
    }
	
	
}

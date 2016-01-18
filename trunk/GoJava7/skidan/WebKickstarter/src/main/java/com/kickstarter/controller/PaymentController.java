package com.kickstarter.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kickstarter.beanVO.PayerVO;
import com.kickstarter.dao.Impl.PaymentAmountDaoImpl;
import com.kickstarter.dao.Impl.PaymentDaoImpl;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	private final int EMPTY_PAYMENT = 0;
	private final String PAYMENT_VIEW = "Payment";
	private final String PROJECT_ID = "projectId";

	@Autowired
	QuestionDaoImpl questionDao;
	@Autowired
	ProjectDaoImpl projectDao;
	@Autowired
	PaymentDaoImpl paymentDao;
	@Autowired
	PaymentAmountDaoImpl paymentAmountDao;

	@RequestMapping("/provide")
	public ModelAndView providePaymentType(@ModelAttribute("payerVO") PayerVO payerVO,@RequestParam Map<String, String> requestParams) {
		int paymentAmount = EMPTY_PAYMENT;
		String projectId = requestParams.get(PROJECT_ID);

		if (requestParams.get("paymentType").isEmpty()) {
			return new ModelAndView("redirect:/project?projectId=" +  projectId);
		}
		
		int paymentType = Integer.parseInt(requestParams.get("paymentType"));
		
		if (paymentType < 3) {
			paymentAmount = paymentAmountDao.getPaymentAmount(paymentType).getAmount();
		}
		ModelAndView modelAndView = new ModelAndView(PAYMENT_VIEW);
		modelAndView.addObject(PROJECT_ID, projectId);
		modelAndView.addObject("paymentAmount", paymentAmount);
		return modelAndView;
	}

	@RequestMapping(value = "/proceed", method = RequestMethod.POST)
	public ModelAndView proceedPayment(@Valid @ModelAttribute("payerVO") PayerVO payerVO, BindingResult result,
			@RequestParam Map<String, String> requestParams) {	
		if (result.hasErrors()) {
			return new ModelAndView(PAYMENT_VIEW)
					.addObject("projectId", requestParams.get(PROJECT_ID));
		}else{
	    int projectId = Integer.parseInt(requestParams.get(PROJECT_ID));
	    int paymentAmount = Integer.parseInt(requestParams.get("paymentAmount"));
	    Project project = projectDao.getOneProject(projectId);
		paymentDao.addPayment(project, paymentAmount);
		    return new ModelAndView("redirect:/project?projectId=" +  projectId);
		}
	}

}

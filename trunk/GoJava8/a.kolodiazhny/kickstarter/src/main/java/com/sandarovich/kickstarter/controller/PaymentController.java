package com.sandarovich.kickstarter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.dto.PaymentForm;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Payment;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.service.PaymentService;
import com.sandarovich.kickstarter.validator.PaymentValidator;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
    private static final String PAYMENT = "payment";
    private static final String PROJECT = "project";
    private static final String SC_NOT_FOUND = "404";
    private static final String PAYMENT_ADD_RESULT = "paymentAddResult";
    private static final String PAYMENT_WAS_NOT_DONE = "Payment was not done";
    private static final String PAYMENT_SUCCESS = "Payment Success";

    @Autowired
    ProjectDao projectDao;

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    AwardDao awardDao;

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String showPayment(@PathVariable Integer projectId, Map<String, Object> model) {
        if (!projectDao.isProjectExist(projectId)) {
            return SC_NOT_FOUND;
        }
        Project project = projectDao.findById(projectId);
        List<Award> awards = awardDao.getByProject(project);
        model.put("title", "Payment");
        model.put("project", project);
        model.put("awards", awards);
		PaymentForm paymentForm = new PaymentForm();
        paymentForm.setProjectId(project.getId());
        model.put("paymentForm", paymentForm);
        return PAYMENT;
    }

	@RequestMapping(value = "/{projectId}", method = RequestMethod.POST)
	public ModelAndView addPayment(@ModelAttribute("paymentForm") PaymentForm paymentForm, BindingResult errors) {
		PaymentValidator paymentValidator = new PaymentValidator();
		paymentValidator.validate(paymentForm, errors);

		if (errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(PAYMENT);
			return modelAndView;
		}

		ModelAndView mav = new ModelAndView("redirect:/" + PROJECT + "/" + paymentForm.getProjectId());
        PaymentService paymentService = new PaymentService();
        mav.setViewName(PAYMENT_ADD_RESULT);

        if (paymentService.allowPayment()) {
            Payment payment = new Payment();
			payment.setCardHolder(paymentForm.getCardHolder());
			payment.setCardNumber(paymentForm.getCardNumber());
            double amount;
			long awardId = paymentForm.getAwardId();
            if (awardId != 0) {
                amount = awardDao.getById(awardId).getAmount();
            } else {
				amount = paymentForm.getAmount();
            }
            payment.setAmount(amount);
			paymentForm.setAmount(amount);
			payment.setProject(projectDao.findById(paymentForm.getProjectId()));
            try {
                paymentDao.pay(payment);
                mav.addObject("title", PAYMENT_SUCCESS);
            } catch (DaoException e) {
                mav.addObject("title", PAYMENT_WAS_NOT_DONE);
            }
        } else {
            mav.addObject("title", PAYMENT_WAS_NOT_DONE);
        }
		mav.addObject("paymentForm", paymentForm);
        return mav;
    }
}

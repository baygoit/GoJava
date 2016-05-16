package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dto.PaymentDto;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Payment;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PaymentController {
    private static final String PAYMENT = "payment";
    private static final String PROJECT = "project";
    private static final String PAYMENT_ADD_RESULT = "paymentAddResult";
    private static final String SC_NOT_FOUND = "404";

    @Autowired
    ProjectDao projectDao;

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    AwardDao awardDao;

    @RequestMapping(value = "/" + PAYMENT + "/{projectId}", method = RequestMethod.GET)
    public String showPayment(@PathVariable Integer projectId, Map<String, Object> model) {
        if (!projectDao.isProjectExist(projectId)) {
            return SC_NOT_FOUND;
        }
        Project project = projectDao.findById(projectId);
        List<Award> awards = awardDao.getByProject(project);
        model.put("title", "Payment");
        model.put("project", project);
        model.put("awards", awards);
        PaymentDto paymentForm = new PaymentDto();
        paymentForm.setProjectId(project.getId());
        model.put("paymentForm", paymentForm);
        return PAYMENT;
    }

    //TODO Implement functionality to store payment Award Id not only amount as per now
    @RequestMapping(value = "/" + PAYMENT + "/{projectId}", method = RequestMethod.POST)
    ModelAndView addPayment(@ModelAttribute("paymentForm") PaymentDto paymentDto) {
        ModelAndView mav = new ModelAndView("redirect:/" + PROJECT + "/" + paymentDto.getProjectId());
        PaymentService paymentService = new PaymentService();
        mav.setViewName(PAYMENT_ADD_RESULT);

        if (paymentService.allowPayment()) {
            Payment payment = new Payment();
            payment.setCardHolder(paymentDto.getCardHolder());
            payment.setCardNumber(paymentDto.getCardNumber());
            double amount;
            long awardId = paymentDto.getAwardId();
            if (awardId != 0) {
                amount = awardDao.getById(awardId).getAmount();
            } else {
                amount = paymentDto.getAmount();
            }
            payment.setAmount(amount);
            paymentDto.setAmount(amount);
            payment.setProject(projectDao.findById(paymentDto.getProjectId()));
            paymentDao.pay(payment);
            mav.addObject("title", "Payment Success");
        } else {
            mav.addObject("title", "Payment was not done");
        }
        mav.addObject("dto", paymentDto);
        return mav;
    }
}

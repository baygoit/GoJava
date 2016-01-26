package com.kickstarter.controller;

import java.util.Map;
import javax.validation.Valid;

import com.kickstarter.beanVO.PayerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.dao.Impl.PaymentAmountDaoImpl;
import com.kickstarter.dao.Impl.PaymentDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final int EMPTY_PAYMENT = 0;
    private final String PAYMENT_VIEW = "Payment";
    private final String PROJECT_ID = "projectId";
    private final String PAYMENT_AMOUNT = "paymentAmount";
    private final String PAYMENT_TYPE = "paymentType";

    @Autowired
    QuestionDaoImpl questionDao;
    @Autowired
    PaymentDaoImpl paymentDao;
    @Autowired
    PaymentAmountDaoImpl paymentAmountDao;

    @RequestMapping("/provide")
    public ModelAndView providePaymentType(@ModelAttribute("payerVO") PayerVo payerVo,
                                           @RequestParam Map<String, String> requestParams) {
        int paymentAmount = EMPTY_PAYMENT;
        String projectId = requestParams.get(PROJECT_ID);

        if (requestParams.get(PAYMENT_TYPE).isEmpty()) {
            return new ModelAndView("redirect:/project?projectId=" + projectId);
        }

        int paymentType = Integer.parseInt(requestParams.get(PAYMENT_TYPE));

        if (paymentType < paymentAmountDao.getPresetPaymetnsCount()) {
            paymentAmount = paymentAmountDao.getPaymentAmount(paymentType).getAmount();
        }
        ModelAndView modelAndView = new ModelAndView(PAYMENT_VIEW);
        modelAndView.addObject(PROJECT_ID, projectId);
        modelAndView.addObject(PAYMENT_AMOUNT, paymentAmount);
        return modelAndView;
    }

    @RequestMapping(value = "/proceed", method = RequestMethod.POST)
    public ModelAndView proceedPayment(@Valid @ModelAttribute("payerVO") PayerVo payerVo, BindingResult result,
                                       @RequestParam Map<String, String> requestParams) {
        if (result.hasErrors()) {
            return new ModelAndView(PAYMENT_VIEW).addObject(PROJECT_ID, requestParams.get(PROJECT_ID));
        }
        int projectId = Integer.parseInt(requestParams.get(PROJECT_ID));
        int paymentAmount = Integer.parseInt(requestParams.get(PAYMENT_AMOUNT));
        paymentDao.addPayment(projectId, paymentAmount);
        return new ModelAndView("redirect:/project?projectId=" + projectId);

    }

}

package com.kickstarter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kickstarter.dao.Impl.PaymentDaoImpl;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;

@Controller
@RequestMapping("/payment")
public class paymentController {

    @Autowired
    QuestionDaoImpl questionDao;
    @Autowired
    ProjectDaoImpl projectDao;
    @Autowired
    PaymentDaoImpl paymentDao;

    @RequestMapping("/providePaymentType")// FIXME
    public ModelAndView providePaymentType(@RequestParam Map<String, String> requestParams) {
        String projectId = requestParams.get("projectId");

        if (requestParams.get("paymentType").isEmpty()) {

            return new ModelAndView("SingleProject", "projectId", projectId);
        }
        int paymentType = Integer.parseInt(requestParams.get("paymentType"));
        int firstPaymentType = 50;
        int secondPaymentType = 100;
        int thirdPaymentType = 150;
        Integer tempPaymentType = null;
        String jsp = "Payment";

        switch (paymentType) {
            case 1:
                tempPaymentType = firstPaymentType;
                break;
            case 2:
                tempPaymentType = secondPaymentType;
                break;
            case 3:
                tempPaymentType = thirdPaymentType;
                break;
            default:
                jsp = "FullPayment";
                break;
        }
        ModelAndView modelAndView = new ModelAndView(jsp);
        modelAndView.addObject("projectId", projectId);
        modelAndView.addObject("paymentAmount", tempPaymentType);
        return modelAndView;
    }

    @RequestMapping("/proceedPayment")// FIXME
    public String proceedPayment(@RequestParam Map<String, String> requestParams) {
        int projectId = Integer.parseInt(requestParams.get("projectId"));
        Integer paymentAmount;
        try {
            paymentAmount = Integer.parseInt(requestParams.get("paymentAmount"));
            if (paymentAmount > 0) {// FIXME
                Project project = projectDao.getOneProject(projectId);
                paymentDao.addPayment(project, paymentAmount);
            }
        } catch (Exception e) {
            //add log // FIXME
        }
        return "redirect:/project?projectId=" + projectId;
    }

}

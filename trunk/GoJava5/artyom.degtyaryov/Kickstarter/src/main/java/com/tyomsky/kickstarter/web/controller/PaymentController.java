package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @Autowired
    private ProjectDAO projectDao;

    @Autowired
    private PaymentProcessor paymentProcessor;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String submitPayment(@RequestParam int projectId, @RequestParam int amount, Model model) {
        model.addAttribute("projectId", projectId);
        model.addAttribute("amount", amount);
        return "payment";
    }

    @RequestMapping(value = "/payment/confirmed", method = RequestMethod.POST)
    public String processPayment(@RequestParam int projectId, @RequestParam int amount, @RequestParam String cardNumber, Model model) {
        Project project = projectDao.get(projectId);
        paymentProcessor.processPayment(project, amount, cardNumber);

        return "redirect:/project?projectId="+projectId;
    }

}

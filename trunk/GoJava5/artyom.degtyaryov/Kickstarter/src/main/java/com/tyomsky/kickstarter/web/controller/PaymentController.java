package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.PaymentService;
import com.tyomsky.kickstarter.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "**/project/{projectId}/payment")
public class PaymentController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submitPayment(@PathVariable(value = "projectId") int projectId, @RequestParam int amount, Model model) {
        model.addAttribute("projectId", projectId);
        model.addAttribute("amount", amount);
        return "payment";
    }

    @RequestMapping(value = "add/confirmed", method = RequestMethod.POST)
    public String processPayment(@PathVariable(value = "projectId")int projectId, @RequestParam int amount, @RequestParam String cardNumber, Model model) {
        Project project = projectService.getProjectById(projectId);
        paymentService.processPayment(project, amount, cardNumber);

        return "redirect:/project/"+projectId+"/";
    }

}

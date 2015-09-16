package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Payment;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public boolean processPayment(Payment payment) {
        if (payment == null){
            return false;
        } else {
            return processPayment(payment.getProject(), payment.getAmount(), payment.getPayer());
        }
    }

    @Override
    public boolean processPayment(Project project, int amount, String payer) {
        if (project == null){
            return false;
        }
        project.setBalance(project.getBalance() + amount);
        projectDAO.merge(project);
        return true;
    }

}

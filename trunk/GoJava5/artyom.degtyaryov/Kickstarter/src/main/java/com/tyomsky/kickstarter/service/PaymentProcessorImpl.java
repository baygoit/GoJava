package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Payment;
import com.tyomsky.kickstarter.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessorImpl implements PaymentProcessor {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public boolean processPayment(Payment payment) {
        if (payment == null || payment.getProject() == null){
            return false;
        }
        Project project = payment.getProject();
        int amount = payment.getAmount();
        project.setBalance(project.getBalance() + amount);
        projectDAO.merge(project);

        return true;
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

package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.sql.Date;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;

public class PaymentPageController extends PageController<Project> {

    @Override
    protected void handle() {
        
        page.showPaymentRequest();
        
    }

    public boolean processPayment(Project project, String paymentRequest) {
        String[] paymentParameters = paymentRequest.split(" ");

        if (paymentParameters.length != 3) {
            return false;
        } else {
            try {
                long sum = Long.parseLong(paymentParameters[2]);
                long cardID = Long.parseLong(paymentParameters[1]);
                String username = paymentParameters[0];
                
                PaymentStorage paymentDAO = storageFactory.getPaymentDAO();
                
                Payment payment = new Payment(project.getId(), username, cardID, sum, new Date(System.currentTimeMillis()));
                paymentDAO.add(payment);

                project.setBalanceSum(paymentDAO.getSum(project.getId()));

            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected boolean isDone() {
        try {
            if (!processPayment(request, inputReader.readLine())) {
                return false;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }
}

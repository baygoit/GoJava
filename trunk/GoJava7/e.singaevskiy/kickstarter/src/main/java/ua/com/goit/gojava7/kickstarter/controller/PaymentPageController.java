package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.util.Date;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;

public class PaymentPageController extends PageController<Project> {

    @Override
    protected void handle() {
        
        page.showPaymentRequest(request);
        
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
                
                PledgeStorage pledgeDAO = storageFactory.getPledgeDAO();
                DataStorage<Payment> paymentDAO = storageFactory.getPaymentDAO();
                
                Payment payment = new Payment(new User(username), cardID, sum, new Date());
                paymentDAO.add(payment);
                Pledge pledge = new Pledge(project, payment);
                pledgeDAO.add(pledge);

                project.setBalanceSum(pledgeDAO.getSum(project));

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

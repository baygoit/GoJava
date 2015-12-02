package ua.com.goit.gojava7.kickstarter.controller.console;

import java.io.IOException;
import java.sql.Date;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class PaymentPageController extends AbstractPageController<Project> {

    @Override
    protected void handle() {
        
        printer.showPaymentRequest();
        
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
                
                PaymentDAO paymentDAO = storageFactory.getPaymentDAO();
                
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

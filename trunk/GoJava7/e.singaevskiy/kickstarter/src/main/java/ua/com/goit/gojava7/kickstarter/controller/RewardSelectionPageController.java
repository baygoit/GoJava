package ua.com.goit.gojava7.kickstarter.controller;

import java.util.Date;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;

public class RewardSelectionPageController extends PageController<Project> {

    private List<Reward> rewards;

    @Override
    protected void handle() {
        rewards = storageFactory.getRewardDAO().getByProject(request);
        page.showRewards(rewards);

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
        int option_anyAmount = rewards.size() + 1;

        int option = getMenuOptionFromUser(option_anyAmount);
        
        if (option == OPTION_EXIT) {
            return true;
        } else if (option == option_anyAmount) {
            dispatchNext(request, new PaymentPageController());
        } else {
            dispatchNext(rewards.get(option-1), new PaymentWithRewardPageController());
        }

        return true;
    }
}

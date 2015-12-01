package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;

public class PaymentOptionState extends PaymentState {

    private Payment payment;

    public PaymentOptionState(Payment payment) {
        this.payment = payment;
        menu = "Enter 1 - invest 1$\n"
                + "Enter 2 - invest 10$\n"
                + "Enter 3 - invest 40$\n"
                + "Enter 4 - invest another amount\n";
    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public boolean validate(String data) {
        try {
            int n = Integer.parseInt(data);

            return n == 1 || n == 2 || n == 3 || n == 4;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void changeState(Console context) {
        String inData = getInData();
        int inDateToInt = Integer.parseInt(inData);
        if (inDateToInt == 1) {
            savePayment(1);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 2) {
            savePayment(10);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 3) {
            savePayment(40);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 4) {
            context.setCurrentState(new ContributionAmountState(payment));
        }
    }

    protected void savePayment(int amount) {
        payment.setTotal(amount);
        DaoFactory.getPaymentDao(getCurrentDataType()).savePayment(payment);
    }

}

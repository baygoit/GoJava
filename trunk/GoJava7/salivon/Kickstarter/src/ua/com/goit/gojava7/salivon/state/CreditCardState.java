package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;

class CreditCardState extends PaymentState {

    private Payment payment;

    public CreditCardState(Payment payment) {
        this.payment = payment;
        menu = "Enter credit card number:";
    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public boolean validate(String data) {
        long number = 0;
        try {
            number = Long.parseLong(data);
        } catch (NumberFormatException e) {

            return false;
        }
        return true;
    }

    @Override
    public void changeState(Console context) {
        long numberCard = Long.parseLong(getInData());
        payment.setNumberCard(numberCard);
        context.setCurrentState(new PaymentOptionState(payment));
    }

}

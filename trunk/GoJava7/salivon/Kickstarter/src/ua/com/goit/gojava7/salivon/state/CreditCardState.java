package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateCreditCard;

class CreditCardState extends PaymentState {

    private Payment payment;

    public CreditCardState(Payment payment) {
        this.payment = payment;
        handler = new ErrorHandlerStateCreditCard();
        menu = "Enter credit card number:";
    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public void changeState(Console context) {
        long numberCard = Long.parseLong(getInData());
        payment.setNumberCard(numberCard);
        context.setCurrentState(new PaymentOptionState(payment));
    }

}

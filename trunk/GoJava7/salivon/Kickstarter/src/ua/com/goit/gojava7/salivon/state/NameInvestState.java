package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateNameInvest;

public class NameInvestState extends PaymentState {

    private Payment payment = new Payment(State.getIdProject());

    public NameInvestState() {
        handler = new ErrorHandlerStateNameInvest();
        menu = "Enter your name:";

    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public void changeState(Console context) {
        payment.setNamePayer(getInData());
        context.setCurrentState(new CreditCardState(payment));
    }

}

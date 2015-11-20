package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateNameInvest;

public class NameInvestState extends PaymentState {

    public NameInvestState() {
        handler = new ErrorHandlerStateNameInvest();
        menu = "Enter your name:";

    }

    @Override
    public void outputContentState() {
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        context.setCurrentState(new CreditCardState());
    }

}

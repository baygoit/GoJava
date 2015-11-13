package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateContributionAmount;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateCreditCard;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateNameInvest;

class CreditCardState extends PaymentState {

    public CreditCardState() {
        handler = new ErrorHandlerStateCreditCard();
        menu = "Enter credit card number:";
    }

    @Override
    public void outputContentState() {
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        context.setCurrentState(new PaymentOptionState());
    }

}

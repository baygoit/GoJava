package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStatePaymentOption;

public class PaymentOptionState extends PaymentState {

    public PaymentOptionState() {
        handler = new ErrorHandlerStatePaymentOption();
        menu = "Enter 1 - invest 1$\n"
                + "Enter 2 - invest 10$\n"
                + "Enter 3 - invest 40$\n"
                + "Enter 4 - invest another amount\n";
    }

    @Override
    public void outputContentState() {
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        int inDateToInt = Integer.parseInt(inData);
        int index = State.getIndexProject() - 1;
        Project project = projects.get(index);
        if (inDateToInt == 1) {
            project.setCollectedAmount(1);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 2) {
            project.setCollectedAmount(10);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 3) {
            project.setCollectedAmount(40);
            context.setCurrentState(new ProjectState());
        } else if (inDateToInt == 4) {
            context.setCurrentState(new ContributionAmountState());
        }
    }

}

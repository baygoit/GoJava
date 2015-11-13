package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateContributionAmount;

class ContributionAmountState extends PaymentState {

    public ContributionAmountState() {
        handler = new ErrorHandlerStateContributionAmount();
        menu = "Enter the contribution amount:";
    }

    @Override
    public void outputContentState() {
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        int amount = Integer.parseInt(inData);
        int index = State.getIndexProject() - 1;
        Project project = projects.get(index);
        project.setCollectedAmount(amount);
        context.setCurrentState(new ProjectState());
    }

}

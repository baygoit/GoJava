package ua.com.goit.gojava7.salivon.handlers;

import ua.com.goit.gojava7.salivon.state.State;

public class ErrorHandlerStateContributionAmount implements ErrorHandler {

    @Override
    public boolean validate(String inData) {
        int amount = 0;
        try {
            amount = Integer.parseInt(inData);
        } catch (NumberFormatException e) {

            return false;
        }
        return true;
    }

}

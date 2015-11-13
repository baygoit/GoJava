package ua.com.goit.gojava7.salivon.handlers;

import ua.com.goit.gojava7.salivon.handlers.ErrorHandler;

public class ErrorHandlerStateProject implements ErrorHandler {

    @Override
    public boolean validate(String inData) {

        try {
            int n = Integer.parseInt(inData);

            return n == 0 || n == 1 || n == 2;

        } catch (NumberFormatException e) {
            return false;
        }

    }

}

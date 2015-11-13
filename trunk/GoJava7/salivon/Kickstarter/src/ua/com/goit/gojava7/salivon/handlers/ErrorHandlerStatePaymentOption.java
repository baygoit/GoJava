package ua.com.goit.gojava7.salivon.handlers;

public class ErrorHandlerStatePaymentOption implements ErrorHandler {

    @Override
    public boolean validate(String inData) {
        try {
            int n = Integer.parseInt(inData);

            return n == 1 || n == 2 || n == 3 || n == 4;

        } catch (NumberFormatException e) {
            return false;
        }
    }

}

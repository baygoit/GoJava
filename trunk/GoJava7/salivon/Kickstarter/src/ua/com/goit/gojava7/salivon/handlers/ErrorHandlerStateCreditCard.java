package ua.com.goit.gojava7.salivon.handlers;

public class ErrorHandlerStateCreditCard implements ErrorHandler {

    @Override
    public boolean validate(String inData) {
    long number = 0;
        try {
            number = Long.parseLong(inData);
        } catch (NumberFormatException e) {

            return false;
        }
        return true;
    }

}

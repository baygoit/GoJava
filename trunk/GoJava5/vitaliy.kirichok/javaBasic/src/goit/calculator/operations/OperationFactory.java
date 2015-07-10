package goit.calculator.operations;

import goit.common.ParseException;

public class OperationFactory {

    private static final String ERROR_MESSAGE = "Unknow operation type \"%s\".";

    public static Operation getOperation(int firstOperand, int secondOperand, String operationType) throws ParseException {
        Operation result;
        switch (operationType) {
            case "-":
                result = new Subtraction(firstOperand, secondOperand);
                break;
            case "*":
                result = new Multiplication(firstOperand, secondOperand);
                break;
            case "/":
                result = new Division(firstOperand, secondOperand);
                break;
            case "+":
                result = new Addition(firstOperand, secondOperand);
                break;
            default:
                throw new ParseException(String.format(ERROR_MESSAGE, operationType));
        }
        return result;
    }
}

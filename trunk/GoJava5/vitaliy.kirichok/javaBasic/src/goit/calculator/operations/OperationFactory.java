package goit.calculator.operations;

import goit.common.ParseException;

public class OperationFactory {

    public static Operation getOperation(int firstOperand, int secondOperand, String operationType) throws ParseException {
        Operation result;
        if (operationType.equals("-")) {
            result = new Subtraction(firstOperand, secondOperand);
        } else if (operationType.equalsIgnoreCase("*")) {
            result = new Multiplication(firstOperand, secondOperand);
        } else if (operationType.equals("/")) {
            result = new Division(firstOperand, secondOperand);
        } else if (operationType.equals("+")) {
            result = new Addition(firstOperand, secondOperand);
        } else {
            throw new ParseException("Unknow operation type ".concat("\"").concat(operationType).concat("\"."));
        }
        return result;
    }
}

package goit.calculator.parsers;

import goit.calculator.operations.Operation;
import goit.calculator.operations.OperationFactory;
import goit.common.ParseException;

public class SimpleParser implements Parser {

    private static final String ERROR_MESSAGE = "Error when parsing string: \"%s\".";
    private static final String inputPattern = "^[\\+|\\-]?\\d+[\\+|\\-\\*\\/]{1}\\d+$";
    private static final String operationPattern = "[\\+|\\-\\*\\/]";
    private static final String signPattern = "^[\\+|\\-]{1}.*$";

    private boolean isValid(String text) {
        return text.matches(inputPattern);
    }

    public Operation parse(String input) throws ParseException {
        String result = input.replaceAll("\\s", "");
        if (!isValid(result)) {
            throw new ParseException(String.format(ERROR_MESSAGE, input));
        }

        String firstOperandSign = "+";
        if (result.matches(signPattern)) {
            firstOperandSign = result.substring(0, 1);
            result = result.substring(1);
        }
        String[] operand = result.split(operationPattern);
        String operation = result.substring(operand[0].length(), operand[0].length() + 1);
        operand[0] = firstOperandSign.concat(operand[0]);

        return OperationFactory.getOperation(Integer.parseInt(operand[0]), Integer.parseInt(operand[1]), operation);
    }
}

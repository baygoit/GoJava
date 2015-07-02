package com.tyomsky;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tyomsky.operations.Addition;
import com.tyomsky.operations.Operation;
import com.tyomsky.operations.OperationFactory;

public class Parser {

    public static final String EXPRESSION_DELIMITER = "(?<=op)|(?=op)".replace("op", "[-+*/]");
    public static final Pattern validationPattern = Pattern.compile("^\\s*([-+]?)(\\d+)(?:\\s*([-+*\\/])\\s*([-+]?)(\\d+))\\s*([=])+$");

    public Expression parseExpression(String input) {
        String[] expressionMembers = getExpressionMembers(input.substring(0, input.indexOf('=')));
        Expression expression = new Expression();
        expression.setLeftExpression(getIntegerMember(expressionMembers[0]));
        expression.setRightExpression(getIntegerMember(expressionMembers[2]));
        Operation operation = new OperationFactory().getOperation(expressionMembers[1].charAt(0));
        expression.setOperation(operation);
        return expression;
    }

    public String[] getExpressionMembers(String input) {
        String[] result;
        result = input.split(EXPRESSION_DELIMITER);
        return result;
    }

    public boolean verify(String input) {
        Matcher matcher = validationPattern.matcher(input);
        return matcher.matches();
    }

    public int getIntegerMember(String member) {
        int result = 0;
        try {
            result = Integer.parseInt(member);
        } catch (NumberFormatException e) {
            System.err.println(member + " is not integer!");
        }
        return result;
    }
}

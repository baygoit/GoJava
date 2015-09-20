package goit.nz.lesson1.calculator;

import java.util.HashSet;

public class ExpressionBuilder {
	private final String DELIMETER = " ";
	private HashSet<String> validOperators;
	private String[] expressionComponents;
	private int firstOperand;
	private int secondOperand;
	private String operator;
	private String errorMessage;

	public ExpressionBuilder() {
		this.validOperators = new HashSet<String>();
		this.validOperators.add("+");
		this.validOperators.add("-");
	}

	public boolean parseInput(String input) {
		this.errorMessage = "";
		if (input.isEmpty()) {
			this.errorMessage = "Empty expression!";
			return false;
		}
		expressionComponents = input.split(this.DELIMETER);
		if (expressionComponents.length != 3) {
			this.errorMessage = "Expression has wrong number of arguments!";
			return false;
		}
		return parseExpressionComponents();
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public Computable getExspression() {
		BinaryExpression expression;
		switch (this.operator) {
		case "+":
			expression = new Addition(this.firstOperand, this.secondOperand);
			break;
		case "-":
			expression = new Substraction(this.firstOperand, this.secondOperand);
			break;
		default:
			expression = null;
			break;
		}
		return (Computable) expression;
	}

	private boolean parseExpressionComponents() {
		try {
			this.firstOperand = Integer.parseInt(this.expressionComponents[0]);
		} catch (NumberFormatException e) {
			this.errorMessage = "First operand is incorrect!";
			return false;
		}
		try {
			this.secondOperand = Integer.parseInt(this.expressionComponents[2]);
		} catch (NumberFormatException e) {
			this.errorMessage = "Second operand is incorrect!";
			return false;
		}
		this.operator = this.expressionComponents[1];
		if (isValidOperator()) {
			return true;
		}
		this.errorMessage = "Operator \"" + this.operator
				+ "\" is not supported!";
		return false;
	}

	private boolean isValidOperator() {
		return this.validOperators.contains(this.operator);
	}
}

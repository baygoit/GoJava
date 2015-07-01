package goit.nz.lesson1.calculator;

public class Addition extends BinaryExpression {

	public Addition(int first, int second) {
		super(first, second);
	}

	public int compute() {
		return this.firstOperand + this.secondOperand;
	}
}

package goit.nz.lesson1.calculator;

public class Substraction extends BinaryExpression {

	public Substraction(int first, int second) {
		super(first, second);
	}

	public int compute() {
		return this.firstOperand - this.secondOperand;
	}
}

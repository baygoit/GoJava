package goit.nz.lesson1.calculator;

public abstract class BinaryExpression implements Computable {
	protected int firstOperand;
	protected int secondOperand;

	public BinaryExpression(int first, int second) {
		this.firstOperand = first;
		this.secondOperand = second;
	}

	abstract public int compute();
}

package goit.calculator.operations;

public class Subtraction extends Operation {

    public Subtraction(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public Integer compute() {
        return getFirstOperand() - getSecondOperand();
    }
}

package goit.operations;

public class Addition extends Operation {

    public Addition(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public Integer compute() {
        return getFirstOperand() + getSecondOperand();
    }
}

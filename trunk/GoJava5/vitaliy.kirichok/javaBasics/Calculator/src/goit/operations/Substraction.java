package goit.operations;

public class Substraction extends Operation {

    public Substraction(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }
    @Override
    public Integer compute() {
        return getFirstOperand() - getSecondOperand();
    }
}

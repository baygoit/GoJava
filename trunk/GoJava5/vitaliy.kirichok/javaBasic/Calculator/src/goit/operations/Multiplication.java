package goit.operations;

public class Multiplication extends Operation {

    public Multiplication(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }
    @Override
    public Integer compute() {
        return getFirstOperand() * getSecondOperand();
    }

}

package goit.operations;

public class Division extends Operation{

    public Division(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }
    @Override
    public Integer compute() {
        return getFirstOperand() / getSecondOperand();
    }

}

package goit.calculator.operations;

public abstract class Operation {
    private int firstOperand;
    private int secondOperand;

    public Operation(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public abstract Integer compute();

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

}

package goit.operations;

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

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public static Operation create(int firstOperand, int secondOperand, String operationType) {
        Operation result;
        if (operationType.compareTo("-") == 0) {
            result = new Substraction(firstOperand, secondOperand);
        } else if (operationType.compareTo("*") == 0) {
            result = new Multiplication(firstOperand, secondOperand);
        } else if (operationType.compareTo("/") == 0) {
            result = new Division(firstOperand, secondOperand);
        } else {
            result = new Addition(firstOperand, secondOperand);
        }
        return result;
    }

    ;

}

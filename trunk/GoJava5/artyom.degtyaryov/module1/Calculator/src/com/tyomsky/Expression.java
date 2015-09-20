package com.tyomsky;

import com.tyomsky.operations.Operation;

public class Expression {

    private int leftExpression;
    private int rightExpression;
    private Operation operation;

    public Expression(int leftExpression, int rightExpression, Operation operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Expression() {
    }

    public void setRightExpression(int rightExpression) {
        this.rightExpression = rightExpression;
    }

    public void setLeftExpression(int leftExpression) {
        this.leftExpression = leftExpression;
    }

    public int getValue(){
        return operation.perform(leftExpression, rightExpression);
    }
}

package com.tyomsky;

import com.tyomsky.operations.Operation;

/**
 * Created by tyoms_000 on 30.06.2015.
 */
public class Expression {
    int leftExpression;
    int rightExpression;
    Operation operation;

    public Expression(int leftExpression, int rightExpression, Operation operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    public int getValue(){
        return operation.perform(leftExpression, rightExpression);
    }
}

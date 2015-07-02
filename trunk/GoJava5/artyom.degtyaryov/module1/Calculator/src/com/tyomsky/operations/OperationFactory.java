package com.tyomsky.operations;

public class OperationFactory {

    public Operation getOperation(char operationLiteral) throws IllegalArgumentException {
        switch (operationLiteral) {
            case '+': {
                return new Addition();
            }
            case '-': {
                return new Subtraction();
            }
            default:
                throw new IllegalArgumentException("Not supported operation");

        }
    }
}

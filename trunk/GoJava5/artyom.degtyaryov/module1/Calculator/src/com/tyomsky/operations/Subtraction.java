package com.tyomsky.operations;

public class Subtraction implements Operation{

	@Override
	public int perform(int leftExpression, int rightExpression) {
		return leftExpression - rightExpression;
	}

}

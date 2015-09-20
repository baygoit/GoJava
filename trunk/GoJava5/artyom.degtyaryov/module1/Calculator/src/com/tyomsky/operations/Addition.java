package com.tyomsky.operations;

public class Addition implements Operation{

	@Override
	public int perform(int leftExpression, int rightExpression) {
		return leftExpression + rightExpression;
	}

}

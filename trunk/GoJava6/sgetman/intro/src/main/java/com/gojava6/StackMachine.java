/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6;

import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/7/15
 */
public class StackMachine {
    private static char MULTIPLY = '*';
    private static char ADD = '+';
    private Stack<Integer> stack = new Stack<Integer>();

    BinaryOperator<Integer> add = (a, b) -> a + b;
    BinaryOperator<Integer> multiply = (a, b) -> a * b;
    ArithmeticalInterface<Integer> arithmeticalOperator
            =  (a, b, c) -> c.apply(a, b);

    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return -1;
        }
        char[] elements = S.toCharArray();
        for (char c : elements) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
                continue;
            }



            if (c == ADD) {
                if (stack.size() < 2) {
                    return -1;
                }
                stack.push(arithmeticalOperator.apply(stack.pop(), stack.pop(), add));
                continue;
            }

            if (c == MULTIPLY) {
                if (stack.size() < 2) {
                    return -1;
                }
                stack.push(arithmeticalOperator.apply(stack.pop(), stack.pop(), multiply));
                continue;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new StackMachine().solution("13+62*7+*"));
    }
}

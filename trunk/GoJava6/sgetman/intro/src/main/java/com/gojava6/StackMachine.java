/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6;

import java.util.Stack;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/7/15
 */
public class StackMachine {
    private static char MULTIPLY = '*';
    private static char ADD = '+';
    private Stack<Integer> stack = new Stack<Integer>();

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
                stack.push(stack.pop() + stack.pop());
                continue;
            }

            if (c == MULTIPLY) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new StackMachine().solution("13+62*7+*"));
    }
}

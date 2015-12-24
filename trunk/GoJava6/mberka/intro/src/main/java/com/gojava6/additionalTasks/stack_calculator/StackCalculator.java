package com.gojava6.additionalTasks.stack_calculator;

import java.util.Stack;

public class StackCalculator {
    private static Stack<String> stack;
    private boolean stringIsValid;

    public void fill(String string) {
        if (isValid(string)) {
            stack.push(string);
        }
    }

    public boolean isValid(String string) {
        boolean numberIsValid = false;
        boolean signIsValid = false;

        if (string.matches("^\\d+$")) {
            if (Integer.valueOf(string) >= 0
                    && Integer.valueOf(string) <= 9) {
                numberIsValid = true;
            } else {
                try {
                    throw new Exception("-1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (string.contains("+") || string.contains("*")) {
            signIsValid = true;
        } else {
            try {
                throw new Exception("-1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (numberIsValid || signIsValid) {
            stringIsValid = true;
        } else {
            try {
                throw new Exception("-1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringIsValid;
    }

    public void calculate() {
        String s = stack.pop();
        String result = null;

        if (!stack.empty()) {
            if (s.equals("+")) {
                String st1 = stack.pop();
                String st2 = stack.pop();
                result = add(st1, st2);
                stack.push(result);
            }
            if (s.equals("*")) {
                String st1 = stack.pop();
                String st2 = stack.pop();
                result = multiply(st1, st2);
                stack.push(result);
            }
        } else {
            try {
                throw new Exception("-1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String multiply(String st1, String st2) {
        int i1 = Integer.parseInt(st1);
        int i2 = Integer.parseInt(st2);
        return String.valueOf(i1 * i2);
    }

    public String add(String st1, String st2) {
        int i1 = Integer.parseInt(st1);
        int i2 = Integer.parseInt(st2);
        return String.valueOf(i1 + i2);
    }

    public static void main(String[] args) {
        stack = new Stack<>();
        StackCalculator stackCalc = new StackCalculator();

        stackCalc.fill("5");
        stackCalc.fill("2");
        stackCalc.fill("+");

        //TODO

        stackCalc.calculate();

        System.out.println(stack.peek());
    }
}

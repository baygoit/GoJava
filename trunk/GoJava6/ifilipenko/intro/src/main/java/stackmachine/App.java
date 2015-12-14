package stackmachine;

import java.util.Stack;

public class App {

    private Stack<Integer> machine = new Stack<>();

    public int callStackMachineM(String line) {
        int result = 0;
        String[] tokens;

        if (line.length() == 0 || line.length() <= 2) {
            return -1;
        } else {
            tokens = split(line);
            for (int i = 0; i < tokens.length; i++) {
                if (isDigitM(tokens[i])) {
                    int digit = Integer.valueOf(tokens[i]);
                    machine.push(digit);
                } else if (tokens[i].equals("+") && (machine.size() >= 2)) {
                    result = add();
                    machine.push(result);
                } else if (tokens[i].equals("*") && (machine.size() >= 2)) {
                    result = multiply();
                    machine.push(result);
                } else if (!isDigitM(tokens[i]) && tokens.length >= tokens.length - 1) {
                    continue;
                } else {
                    return -1;
                }
            }
        }
        return result;

    }

    public int callStackMachine(String line) {
        int result = 0;
        char[] arr;

        if (line.length() == 0 || line.length() <= 2) {
            return -1;
        } else {
            arr = parse(line);
            for (int i = 0; i < arr.length; i++) {
                if (isDigit(arr[i])) {
                    int digit = Character.getNumericValue(arr[i]);
                    machine.push(digit);
                } else if (new Character(arr[i]).equals('+') && (machine.size() >= 2)) {
                    result = add();
                    machine.push(result);
                } else if (new Character(arr[i]).equals('*') && (machine.size() >= 2)) {
                    result = multiply();
                    machine.push(result);
                } else if (!isDigit(arr[i]) && arr.length >= arr.length - 1) {
                    continue;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }

    private char[] parse(String line) {
        return line.toCharArray();
    }

    private String[] split(String line) {
        return line.split(" ");
    }

    private boolean isDigit(char c) {
        for (int j = 0; j < 10; j++) {
            if (c == j + '0') {
                return true;
            }
        }
        return false;
    }

    private boolean isDigitM(String line) {
        return line.matches("[0-9]");
    }

    private int add() {
        int a = machine.pop();
        int b = machine.pop();
        return a + b;
    }

    private int multiply() {
        int a = machine.pop();
        int b = machine.pop();
        return a * b;
    }

    public int getMachineSize() {
        return machine.size();
    }


}

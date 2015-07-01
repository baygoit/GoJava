package calculator;

public class Calc {
    public static int calc(int num1, String operand, int num2){
        int res = 0;
        switch(operand){
            case "+": res = num1 + num2;
                break;
            case "-": res = num1 - num2;
                break;
            case "*": res = num1 * num2;
                break;
            case "/": res = num1 / num2;
                break;
        }
        return res;
    }
}

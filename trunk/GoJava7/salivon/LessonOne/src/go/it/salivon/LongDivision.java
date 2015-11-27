package go.it.salivon;

import go.it.main.Division;
import java.util.Formatter;
import java.util.Stack;

public class LongDivision extends Division {

    private int divident;
    private int divisor;
    private double result;
    private Stack<Integer> stackDel1;
    private int count;
    private StringBuilder outString = new StringBuilder();

    public static void main(String[] args) {
        LongDivision ld = new LongDivision();
        System.out.println(ld.divide(1, 23));

    }

    @Override
    public String divide(int divident, int divisor) {
        this.divident = divident;
        this.divisor = divisor;
        parseIntToStack(this.divident);
        countIteration();
        print();
        return outString.toString();
    }

    private void countIteration() {
        StringBuilder sb = new StringBuilder(formatResultToStr());
        while (sb.lastIndexOf("0") != -1) {
            sb.deleteCharAt(sb.lastIndexOf("0"));
        }
        count = sb.length() - 2;
    }

    private String formatResultToStr() {
        result = (double) divident / divisor;
        Formatter format = new Formatter();
        format.format("%f", result);
        String s = format.toString();
        return s;
    }

    private int calculatedA(int a, int b) {
        if (a == 0) {
            return 0;
        }
        while (a < b && !stackDel1.empty()) {
            a = combineTwoInt(a, stackDel1.pop());
        }
        while (a < b && stackDel1.empty()) {
            a = combineTwoInt(a, 0);
        }
        return a;

    }

    private int combineTwoInt(int one, int two) {
        String oneStr = String.valueOf(one);
        String twoStr = String.valueOf(two);
        String combination = oneStr + twoStr;
        Integer oneTwo = Integer.parseInt(combination);
        return oneTwo;
    }

    private void parseIntToStack(int number) {
        String s = String.valueOf(number);
        stackDel1 = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stackDel1.push(Integer.valueOf(String.valueOf(s.charAt(i))));
        }
    }

    private void print() {
        if (divisor == 0) {
            printOneString();
            outString.append("Division by zero - error!" + "\n");
            return;
        }
        printOneString();
        String offset = "";
        int a = calculatedA(stackDel1.pop(), divisor);
        int c = a - a % divisor;
        printTwoString(c, formatResultToStr());
        outString.append("----" + "\n");
        for (int i = 1; i <= count; i++) {
            a = a - c;
            a = calculatedA(a, divisor);
            c = a - a % divisor;
            outString.append(offset).append(" ").append(a).append("\n");
            outString.append(offset).append("-").append(c).append("\n");
            outString.append(offset).append("----" + "\n");
            offset += " ";
        }
        outString.append(offset).append(" ").append(a - c).append("\n");
    }

    private void printOneString() {
        outString.append("  ").append(divident).append(" | ").append(divisor).append("\n");

    }

    private void printTwoString(int c, String result) {
        outString.append("-").append(c).append(" | ").append(result).append("\n");
    }
}

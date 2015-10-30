import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 22.10.2015.
 */
public class DivisionProcessor {
    private class ResultOfDivision {
        int number1;
        int number2;
        String sign = "";
        List<Integer> currentNums = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        List<Integer> products = new ArrayList<>();
        List<Integer> offsets = new ArrayList<>();
        int remainderRepeated;
        int indexOfPoint = -1;
        int indexOfPeriodStart = -1;
    }

    public static void main(String[] args) {
        DivisionProcessor processor = new DivisionProcessor();
        int number1 = 24;
        int number2 = 17;
        ResultOfDivision res = processor.processDivision(number1,number2);
        processor.printDivision(res);
        System.out.println();

        System.out.println("Built-in division: " + number1 + " / "
                + (number2 < 0 ? "(" : "")
                + number2
                + (number2 < 0 ? ")" : "")
                + " = " + number1 / (double) number2);
    }

    private void printDivision(ResultOfDivision res) {
        // print first line
        System.out.print(res.number1);
        int lengthDifference = length(res.currentNums.get(0)) - length(res.number1);
        int numberOfSpaces = (lengthDifference >= 0 ? lengthDifference : 0) + 3;
        printSpaces(numberOfSpaces);
        String delimiter = "|__";
        System.out.print(delimiter);
        printSpaces(2);
        if (res.number2 > 0 && res.sign == "-") {
            printSpaces(1);
        }
        System.out.print(res.number2);
        System.out.println();

        // print second line
        int numberOfSpaces2 = (res.number1 < 0 ? 1 : 0) + length(res.currentNums.get(0)) - length(res.products.get(0));
        printSpaces(numberOfSpaces2);
        System.out.print(res.products.get(0));
        int numberOfSpaces1 = (length(res.number1) + numberOfSpaces + delimiter.length() + 2)
                - (numberOfSpaces2 + length(res.products.get(0)));
        printSpaces(numberOfSpaces1);
        if (res.number2 < 0 && res.sign == "") {
            printSpaces(1);
        }
        printResult(res);
        System.out.println();

        // print other lines
        int i = 1;
        for (; i < res.currentNums.size(); i++) {
            if (res.number1 < 0) {
                printSpaces(1);
            }
            printSpaces(res.offsets.get(i) - length(res.currentNums.get(i)) + 1);
            System.out.println(res.currentNums.get(i));
            if (res.number1 < 0) {
                printSpaces(1);
            }
            printSpaces(res.offsets.get(i) - length(res.products.get(i)) + 1);
            System.out.println(res.products.get(i));
        }

        // print last remainder (zero or repeated)
        if (res.number1 < 0) {
            printSpaces(1);
        }
        if (res.indexOfPeriodStart == -1) {
            printSpaces(res.offsets.get(i - 1));
            System.out.println(0);
        } else {
            printSpaces(res.offsets.get(i - 1) - length(res.remainderRepeated) + 1);
            System.out.println(res.remainderRepeated);
        }
    }

    private void printResult(ResultOfDivision res) {
        System.out.print(res.sign);
        int j = 0;
        // ignore leading zeroes
        while (j < res.digits.size()
                && res.digits.get(j) == 0
                && ((res.indexOfPoint == -1 && j < res.digits.size() - 1)
                    || (res.indexOfPoint != -1 && j < res.indexOfPoint - 1))) {
            j++;
        }
        for (; j < res.digits.size(); j++) {
            if (j == res.indexOfPoint) {
                System.out.print(".");
            }
            if (j == res.indexOfPeriodStart) {
                System.out.print("(");
            }
            System.out.print(res.digits.get(j));
        }
        if (res.indexOfPeriodStart != -1) {
            System.out.print(")");
        }
    }

    private ResultOfDivision processDivision(int number1, int number2) {
        ResultOfDivision res = new ResultOfDivision();

        res.sign = findSign(number1,number2);
        res.number1 = number1;
        res.number2 = number2;

        if (number1 == 0 && number2 != 0) {
            res.currentNums.add(0);
            res.digits.add(0);
            res.products.add(0);
            res.offsets.add(0);
            return res;
        }

        int num1 = Math.abs(number1);
        int num2 = Math.abs(number2);

        int[] digits = findDigits(num1);

        int currentNum = 0;
        List<Integer> remainders = new ArrayList<>();
        for (int i = 0, j = 0; ; i++) {
            currentNum = currentNum * 10 + (i < digits.length ? digits[i] : 0);
            int quotient = currentNum / num2;
            int product = quotient * num2;
            int remainder = currentNum - product;
            remainders.add(remainder);
            res.digits.add(quotient);
            j++;
            if (i == digits.length - 1 && remainder != 0) {
                res.indexOfPoint = j;
            }
            if (currentNum >= num2) {
                res.currentNums.add(currentNum);
                res.offsets.add(i);
                res.products.add(product);
                currentNum = remainder;
                if (res.indexOfPoint != -1) {
                    int indexOfRemainderRepeated = findIndexOfRemainderRepeated(remainder, remainders,
                                                                      res.indexOfPoint - 1, remainders.size() - 1);
                    if (indexOfRemainderRepeated != -1) {
                        res.indexOfPeriodStart = indexOfRemainderRepeated + 1;
                        res.remainderRepeated = remainders.get(indexOfRemainderRepeated);
                        break;
                    }
                }
            }
            if (i >= digits.length - 1 && remainder == 0) {
                break;
            }
        }

        return res;
    }

    private int findIndexOfRemainderRepeated(int remainder, List<Integer> remainders, int from, int to) {
        for (int i = from; i < to; i++) {
            if (remainder == remainders.get(i)) {
                return i;
            }
        }
        return -1;
    }

    private int[] findDigits(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Character.getNumericValue(chars[i]);
        }
        return digits;
    }

    private String findSign(int num1, int num2) {
        if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
            return "-";
        }
        return "";
    }

    private int length(int num) {
        return Integer.toString(num).length();
    }

    private void printSpaces(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }

}

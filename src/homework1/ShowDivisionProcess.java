package homework1;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Alex on 12.03.2015.
 */
public class ShowDivisionProcess {
    private static int resultPosition = 0;
    private static int offset = 0;
    private static String result = "";
    private static LinkedHashMap<Long, Long> resultMap = new LinkedHashMap<Long, Long>();
    private static StringBuilder strB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //Examples for testing
        showDivisionProcess("120%4");
        showDivisionProcess("120/4");
        showDivisionProcess("3/8");
        showDivisionProcess(3, 8);
        showDivisionProcess("2.12/1.385");
        showDivisionProcess("3.1234/5");
        showDivisionProcess("12/42");
        showDivisionProcess(13, 19);
        showDivisionProcess(3, 13);
        showDivisionProcess(2, 3000);
        showDivisionProcess(2000, 3);
    }

    public static void showDivisionProcess(String expression) {
        String[] numbers = expression.split("/");
        long num1 = 0;
        long num2 = 0;
        long[] longNumbers = new long[2];
        try {
            longNumbers = convertNumbers(numbers[0], numbers[1]);
        } catch (Exception e) {
            System.out.println("Incorrect string");
            System.out.println();
            return;
        }
        num1 = longNumbers[0];
        num2 = longNumbers[1];
        showDivisionProcess(num1, num2);
    }

    private static long[] convertNumbers(String a, String b) {
        ConvertedNumber num1 = convertValueToLong(a);
        ConvertedNumber num2 = convertValueToLong(b);
        int difference = num1.multiplier-num2.multiplier;
        if (num1.multiplier>=num2.multiplier) {
            num2.value *= Math.pow(10, Math.abs(difference));
        } else {
            num1.value *= Math.pow(10, Math.abs(difference));
        }
        return new long[] {num1.value, num2.value};
    }

    private static class ConvertedNumber {
        long value;
        int multiplier = 0;
    }

    private static ConvertedNumber convertValueToLong(String number) {
        if (number.length()>19) {
            System.out.println("The number indicated is too big");
            throw new IllegalArgumentException();
        }
        ConvertedNumber convertedNumber = new ConvertedNumber();
        if (number.contains(".")) {
            String[] array = number.split("\\.");
            convertedNumber.value = Long.parseLong(array[0]);
            convertedNumber.value *= Math.pow(10, array[1].length());
            convertedNumber.value += Long.parseLong(array[1]);
            convertedNumber.multiplier = array[1].length();
        } else {
            convertedNumber.value = Long.parseLong(number);
        }
        return convertedNumber;
    }

    public static void showDivisionProcess(long number1, long number2) {
        clearStaticVariables();
        result += (number1/number2);
        strB.append(" " + number1 + "|" + number2 + "\n");
        if (number1%number2==0) {
            strB.append("-" + number1 + "|" + "\n");
            resultPosition = strB.length()-1;
            strB.append(repeatCharNTimes(' ', String.valueOf(number1).length()) + "0");
            finaliseCalculation();
            return;
        }
        number1 = (number1%number2)*10;
        result += ".";

        while (number1%number2!=0 && !resultMap.containsKey(number1)) {
            if (number1<number2) {
                resultMap.put(number1, number1/number2);
                number1 *= 10;
                result += "0";
            } else {
                strB.append(repeatCharNTimes(' ', offset) + "-" + number2*(number1/number2) + "\n");
                if (resultPosition==0) {
                    strB.insert(strB.length()-1, "|");
                    resultPosition = strB.length()-1;
                }
                strB.append(repeatCharNTimes(' ', offset) + repeatCharNTimes('-', 4) + "\n");
                if (number1%number2!=0) {
                    strB.append(repeatCharNTimes(' ', offset + 3) + (number1 - (number2 * (number1 / number2))) * 10 + "\n");
                }
                resultMap.put(number1, number1/number2);
                offset += 2;
                result += (number1/number2);
                number1 = (number1%number2)*10;
            }
        }
        if (number1%number2==0) {
            result += (number1/number2);
            strB.append(repeatCharNTimes(' ', offset) + "-" + number2*(number1/number2) + "\n");
            strB.append(repeatCharNTimes(' ', String.valueOf(number1).length() + offset) + "0");
            finaliseCalculation();
            return;
        }
        String period = "";
        boolean periodFound = false;
        for (Map.Entry pair:resultMap.entrySet()) {
            if (number1==(Long)pair.getKey()) {
                periodFound = true;
            }
            if (periodFound==true) {
                period += pair.getValue();
            }
        }
        result += ")";
        String resultCopy = new String(result);
        int fractionPosition = resultCopy.indexOf('.');
        resultCopy = resultCopy.substring(fractionPosition);
        int periodPosition = resultCopy.indexOf(period);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(result);
        sb2.insert(fractionPosition+periodPosition, "(");
        result = sb2.toString();
        finaliseCalculation();
    }

    private static void finaliseCalculation() {
        strB.insert(resultPosition, result);
        System.out.println(strB);
        System.out.println();
    }

    private static void clearStaticVariables() {
        resultPosition = 0;
        offset = 0;
        result = "";
        resultMap.clear();
        strB = new StringBuilder();
    }

    private static String repeatCharNTimes(char ch, int number) {
        return new String(new char[number]).replace('\0', ch);
    }
}

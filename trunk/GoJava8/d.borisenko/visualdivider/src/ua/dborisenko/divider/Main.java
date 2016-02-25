package ua.dborisenko.divider;

import java.util.Scanner;

public class Main {

    private static int MAX_DIGITS_AFTER_COMMA = 10;
    private static int divident;
    private static int divider;
    private static String divideResult;

    private static void printStartConditions() {
        System.out.println("-----------------------------");
        System.out.println(divident + " | " + divider);
        System.out.println("-----------------------------");
    }

    private static void printDivideStep(int tempDivident, int decreaseValue) {
        System.out.println(tempDivident);
        System.out.println(decreaseValue);
        System.out.println("---------");
    }

    private static String takeNextDigit(String tempStrDivident, char digit) {
        if (tempStrDivident.equals("0")) {
            return "" + digit;
        } else {
            return tempStrDivident + digit;
        }
    }

    private static String divideTempValue(String tempStrDivident) {
        int tempDivident = Integer.valueOf(tempStrDivident);
        if (0 == tempDivident) {
            divideResult = divideResult + "0";
        } else if (tempDivident >= divider) {
            int partialResult = tempDivident / divider;
            printDivideStep(tempDivident, partialResult * divider);
            divideResult = divideResult + Integer.toString(partialResult);
            tempDivident = tempDivident - (partialResult * divider);
        }
        return (Integer.toString(tempDivident));
    }

    private static String divideBeforeComma() {
        String strDivident = Integer.toString(divident);
        String tempStrDivident = "";
        divideResult = "";
        for (int i = 0; i < strDivident.length(); i++) {
            tempStrDivident = takeNextDigit(tempStrDivident, strDivident.charAt(i));
            tempStrDivident = divideTempValue(tempStrDivident);
        }
        return (tempStrDivident);
    }

    private static void divideAfterComma(String tempStrDivident) {
        divideResult = divideResult + ",";
        for (int i = 1; i <= MAX_DIGITS_AFTER_COMMA && tempStrDivident != "0"; i++) {
            tempStrDivident = takeNextDigit(tempStrDivident, '0');
            tempStrDivident = divideTempValue(tempStrDivident);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the dividend:");
        Scanner scanner = new Scanner(System.in);
        divident = scanner.nextInt();
        System.out.println("Enter the divider:");
        divider = scanner.nextInt();
        scanner.close();
        printStartConditions();
        String tempStrDivident = divideBeforeComma();
        if (!tempStrDivident.equals("0")) {
            divideAfterComma(tempStrDivident);
        }
        System.out.println("Result: " + divideResult);
    }
}

package ua.dborisenko.visualdivider;

import java.util.Scanner;

public class Application {

    private static int MAX_DIGITS_AFTER_COMMA = 10;
    private int divident;
    private int divider;
    private String divideResult;

    private void printStartConditions() {
        System.out.println("-----------------------------");
        System.out.println(divident + " | " + divider);
        System.out.println("-----------------------------");
    }

    private void printDivideStep(int tempDivident, int decreaseValue) {
        System.out.println(tempDivident);
        System.out.println(decreaseValue);
        System.out.println("---------");
    }

    private String takeNextDigit(String tempStrDivident, char digit) {
        if (tempStrDivident.equals("0")) {
            return "" + digit;
        } else {
            return tempStrDivident + digit;
        }
    }

    private String divideTempValue(String tempStrDivident) {
        int tempDivident = Integer.valueOf(tempStrDivident);
        if (0 == tempDivident) {
            this.divideResult = this.divideResult + "0";
        } else if (tempDivident >= divider) {
            int partialResult = tempDivident / divider;
            printDivideStep(tempDivident, partialResult * divider);
            this.divideResult = this.divideResult + Integer.toString(partialResult);
            tempDivident = tempDivident - (partialResult * divider);
        }
        return (Integer.toString(tempDivident));
    }

    private String divideBeforeComma() {
        String strDivident = Integer.toString(divident);
        String tempStrDivident = "";
        this.divideResult = "";
        for (int i = 0; i < strDivident.length(); i++) {
            tempStrDivident = takeNextDigit(tempStrDivident, strDivident.charAt(i));
            tempStrDivident = divideTempValue(tempStrDivident);
        }
        return (tempStrDivident);
    }

    private void divideAfterComma(String tempStrDivident) {
        this.divideResult = this.divideResult + ",";
        for (int i = 1; i <= MAX_DIGITS_AFTER_COMMA && tempStrDivident != "0"; i++) {
            tempStrDivident = takeNextDigit(tempStrDivident, '0');
            tempStrDivident = divideTempValue(tempStrDivident);
        }
    }

    public void start() {
        System.out.println("Enter the dividend:");
        Scanner scanner = new Scanner(System.in);
        this.divident = scanner.nextInt();
        System.out.println("Enter the divider:");
        this.divider = scanner.nextInt();
        scanner.close();
        printStartConditions();
        String tempStrDivident = divideBeforeComma();
        if (!tempStrDivident.equals("0")) {
            divideAfterComma(tempStrDivident);
        }
        System.out.println("Result: " + divideResult);
    }
}

/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.Scanner;

/**
 * @author Alex Kholmov
 *
 */
public class LongDivision {
    /**
     * @param args
     */
    private static final int MAX_DIGIT_IN_FRACTION = 10;

    public static void main(String[] args) {
        // division A / B
        String inputString = inputStringNumbers();
        int[] TwoNumArray = convertStrToNumArray(inputString);

        int numA = TwoNumArray[0];
        int numB = TwoNumArray[1];

        // System.out.println("numA: " + numA + "\n" + "numB: " + numB);
        int[] digitArrayOfNumA = convertNumToArrayOfDigit(numA);

        // display result
        System.out.print("\n" + numA + " / " + numB);
        System.out.print("\nResult: " + calcDivisionResult(digitArrayOfNumA, numA, numB));
    }

    // method return input string
    public static String inputStringNumbers() {
        String inpStr = "";

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter numbers like A/B: ");
        inpStr = scan.nextLine();
        scan.close();

        return inpStr;
    }

    // method convert input string to array of numbers
    public static int[] convertStrToNumArray(String inpStr) {
        String[] strArray = inpStr.split("/");
        int[] numArray = new int[strArray.length];
        // convert each number to int
        try {
            for (int i = 0; i < strArray.length; i++) {
                numArray[i] = Integer.parseInt(strArray[i].trim());
            }
        } catch (NumberFormatException e) {
            System.err.println("The string must contain only numbers!");
        }
        return numArray;
    }

    // method convert numbers to array of digit
    public static int[] convertNumToArrayOfDigit(int num) {
        int tmpNum = num;
        int[] digitArray = new int[Integer.toString(num).length()];
        for (int i = digitArray.length - 1; i >= 0; i--) {
            digitArray[i] = tmpNum % 10;
            tmpNum /= 10;
        }
        return digitArray;
    }

    // method calculate division and return string result
    public static String calcDivisionResult(int[] aArray, int a, int b) {
        boolean isPeriod = false;
        String result = "";
        int fNumber = aArray[0];
        int reminder = 0;
        int[] reminderArray = new int[MAX_DIGIT_IN_FRACTION];

        // find first part of dividend, if first part dividend is whole dividend
        // exit loop
        int j = 0;
        while (fNumber < b && fNumber != a) {
            fNumber = fNumber * 10 + aArray[j + 1];
            j++;
        }

        // find reminders in each step
        while (j < aArray.length) {
            result += fNumber / b;
            reminder = fNumber % b;
            fNumber = (j == (aArray.length - 1)) ? reminder * 10 : reminder
                    * 10 + aArray[j + 1];
            j++;
        }

        if (reminder != 0) {
            result += ".";
        }

        // calculation fraction part
        int fraction = 0;
        int i = 0;
        int periodIndex = 0;
        while (reminder != 0 && fraction < MAX_DIGIT_IN_FRACTION && !isPeriod) {
            // check reminder on each step
            for (int k = 0; k < reminderArray.length; k++) {
                if (reminder == reminderArray[k]) {
                    isPeriod = true;
                    periodIndex = k - 1;
                    break;
                }
            }
            reminderArray[i] = reminder;
            reminder = fNumber % b;
            if (isPeriod == false) {
                result += fNumber / b;
                fNumber = reminder * 10;
                fraction++;
                i++;
            }
        }
        if (isPeriod && reminder != 0) {
            return periodResult(periodIndex, result);
        } else {
            return result;
        }
    }

    // method format result with period
    public static String periodResult(int index, String res) {
        int dotIndex = res.indexOf(".");
        String bSubStr = res.substring(0, index + dotIndex + 2);
        String eSubStr = res.substring(index + dotIndex + 2, res.length());
        bSubStr += "(";
        eSubStr += ")";
        return bSubStr + eSubStr;
    }
}

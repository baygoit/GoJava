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

        String inputString = inputString();
        int[] numArray = stringToArray(inputString);

        int dividend = numArray[0];
        int divisor = numArray[1];

        int[] digitArray = numberToArray(dividend);

        // display result
        divisionResult(digitArray, dividend, divisor);
    }

    public static String inputString() {
        String inpStr = "";

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter numbers like A/B: ");
        inpStr = scan.nextLine();
        scan.close();

        return inpStr;
    }

    public static int[] stringToArray(String inpStr) {
        String[] strArray = inpStr.split("/");
        int[] numArray = new int[strArray.length];
        // convert each number to int
        for (int i = 0; i < strArray.length; i++) {
            numArray[i] = Integer.parseInt(strArray[i].trim());
        }
        return numArray;
    }

    // method convert numbers to array of digit
    public static int[] numberToArray(int num) {
        int tmpNum = num;
        int[] digitArray = new int[Integer.toString(num).length()];
        for (int i = digitArray.length - 1; i >= 0; i--) {
            digitArray[i] = tmpNum % 10;
            tmpNum /= 10;
        }
        return digitArray;
    }

    public static void divisionResult(int[] aArray, int a, int b) {
        boolean isPeriod = false;
        String result = "";
        String tempResult = "";
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String strfNum = "";
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
        strfNum = Integer.toString(fNumber);
        // find reminders in each step
        int tempNum = 0;
        boolean isFirst = false;
        while (j < aArray.length) {
            result += fNumber / b;
            if (fNumber / b > 0) {
                tempNum = (fNumber / b) * b;
                if (isFirst) {
                    str1 = "\n" + tab(fNumber, j) + " " + fNumber; 
                }
                str2 = "\n" + tab(tempNum, j) + "-" + tempNum; 
                str3 = "\n" + tab(tempNum, j) + " " + "---";
                tempResult += str1 + str2 + str3;
            }
            reminder = fNumber % b;
            fNumber = (j == (aArray.length - 1)) 
                       ? reminder * 10 
                       : reminder * 10 + aArray[j + 1];
            j++;
            isFirst = true;
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
            if (fNumber / b > 0) {
                tempNum = (fNumber / b) * b;
                str1 = "\n" + tab(fNumber, j) + " " + fNumber; 
                str2 = "\n" + tab(tempNum, j) + "-" + tempNum; 
                str3 = "\n" + tab(tempNum, j) + " " + "---";
                tempResult += str1 + str2 + str3;
            }
            reminderArray[i] = reminder;
            reminder = fNumber % b;
            if (isPeriod == false) {
                result += fNumber / b;
                fNumber = reminder * 10;
                fraction++;
                i++;
                j++;
            }
        }
        String firstTab = repeatString(" ", Integer.toString(a).length() - strfNum.length());
        if (isPeriod && reminder != 0) {
            System.out.print("\n" + a + "|" + b);
            System.out.print("\n" + strfNum + firstTab + "|" + formatPeriodResult(periodIndex, result));
            System.out.print(tempResult);
        } else {
            System.out.print("\n" + a + "|" + b);
            System.out.print("\n" + strfNum + firstTab + "|" + result);
            System.out.print(tempResult);
        }
    }

    public static String formatPeriodResult(int index, String res) {
        int dotIndex = res.indexOf(".");
        String bSubStr = res.substring(0, index + dotIndex + 2);
        String eSubStr = res.substring(index + dotIndex + 2, res.length());
        bSubStr += "(";
        eSubStr += ")";
        return bSubStr + eSubStr;
    }
    
    public static String tab(Object o, int width) {
        String tabStr = "";
        int length = o.toString().length();
        tabStr =  repeatString(" ", width - length);
        return tabStr;
    }
    
    public static String repeatString(String s, int j) {
        String resStr = "";
        if (s == null) {
            return "";
        }
        for (int i = 1; i <= j; i++) {
            resStr += s;
        }
        return resStr;
    }
}

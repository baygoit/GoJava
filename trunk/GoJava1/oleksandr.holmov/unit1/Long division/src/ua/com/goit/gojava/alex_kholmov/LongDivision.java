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
    
    static int[] fNumArray = new int[MAX_DIGIT_IN_FRACTION];
    
    public static void main(String[] args) {
        // division A / B
        
        String inputString = inputString();
        int[] numArray = stringToArray(inputString);

        int dividend = numArray[0];
        int divisor = numArray[1];

        int[] digitArray = numberToArray(dividend);
        
        String result = divisionResult(digitArray, dividend, divisor); 
        
        // display result
        System.out.print("\n" + dividend + " / " + divisor);
        System.out.print("\nResult: " + result);
        
        viewResult(dividend, divisor, fNumArray, result);
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

    public static String divisionResult(int[] aArray, int a, int b) {
        boolean isPeriod = false;
        String result = "";
        int fNumber = aArray[0];
        int reminder = 0;
        int[] reminderArray = new int[MAX_DIGIT_IN_FRACTION];

        // find first part of dividend, if first part dividend is whole dividend
        // exit loop
        int j = 0;
        int m = 0;
        while (fNumber < b && fNumber != a) {
            fNumber = fNumber * 10 + aArray[j + 1];
            j++;
        }

        // find reminders in each step
        while (j < aArray.length) {
            result += fNumber / b;
            reminder = fNumber % b;
            fNumber = (j == (aArray.length - 1)) 
                      ? reminder * 10 
                      : reminder * 10 + aArray[j + 1];
            fNumArray[m] = fNumber;
            j++;
            m++;
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
                fNumArray[m] = fNumber;
                fraction++;
                i++;
                m++;
            }
        }
        if (isPeriod && reminder != 0) {
            return formatPeriodResult(periodIndex, result);
        } else {
            return result;
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
    
    public static void viewResult(int a, int b, int[] fNumArr, String res) {
        String tab1 = "";
        String dash = "";
        for (int k = 1; k < (Integer.toString(a).length() - Integer.toString(b)
                .length()); k++) {
            tab1 += " ";
        }
        for (int k = 0; k < Integer.toString(b).length(); k++) {
            dash += "-";
        }

        char[] resArray = res.toCharArray();
        int tmp = Character.getNumericValue(resArray[0]);
        System.out.print("\n" + " " + a + "|" + b);
        System.out.print("\n" + "-" + tmp * b + tab1 + "|" + res);
        System.out.print("\n" + " " + dash);

        for (int k = 1, n = 0; k < resArray.length; k++, n++) {
            if (Character.isDigit(resArray[k])) {
                System.out.print("\n" + " " + fNumArr[n]);
                System.out.print("\n" + "-"
                        + Character.getNumericValue(resArray[k]) * b);
                System.out.print("\n" + " " + dash);
            }
        }
    }
}

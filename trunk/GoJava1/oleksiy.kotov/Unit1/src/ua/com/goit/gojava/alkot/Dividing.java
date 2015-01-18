package ua.com.goit.gojava.alkot;

import java.util.HashMap;
import java.util.Map;

public class Dividing {

    final static int ACCURANCY = 100;
    final static int MAX_OPERAND_VALUE = Integer.MAX_VALUE;
    private static long[] operands = new long[2];
    private static String columnView = "";

    public static void main(String[] args) {
        String arg = "3/1007";
        operands = getOperandsFromString(arg);

        if ((operands[0] < 0) || (operands[1] < 1))
            System.out.println("Numbers are not valid!");
        else {
            newCalculation(operands[0], operands[1]);
            System.out.println(columnView);
        }
    }

    /* get input like "12/42", check limits 0..MAX_INT, set divided divider */
    private static long[] getOperandsFromString(String s) {

        long[] operands = new long[2]; // [divided, divider]
        long tmp;

        for (int i = 0; i < 2; i++) {
            tmp = Long.parseLong(s.split("/")[i]);
            operands[i] = (tmp <= MAX_OPERAND_VALUE) ? tmp : -1;
        }

        return operands;
    }

    static String repeatString(String s, int n) {
        String result = "";
        if (s == null) {
            return "";
        }

        for (int i = 1; i <= n; i++) {
            result += s;
        }

        return result;
    }

    private static String rPad(Object s, int width) {
        String paddedString = "";
        int l = s.toString().length();
        paddedString = repeatString(" ", width - l) + s;
        return paddedString;
    }

    private static String newCalculation(long dividend, long divider) {

        long a = dividend; // a/b=q
        long b = divider;
        long[] aArray = new long[20];// divided in array view
        int aIndex = 1;
        int aMaxIndex = -1;
        String line1 = "";
        String line2 = "";
        String result = "";
        Map<Long, Integer> restList = new HashMap<Long, Integer>();

        int i = 0;
        for (char c : ("" + a).toCharArray()) {
            aArray[i] = Integer.parseInt("" + c);
            i++;
        }
        aMaxIndex = i - 1;

        aIndex = 0;
        long tmpDividend = 0;
        int accPlus = 0;

        while (aIndex < ACCURANCY + accPlus) {

            if ((aIndex > aMaxIndex) && (tmpDividend == 0))
                break;

            if (aIndex > aMaxIndex) {
                if (restList.containsKey(tmpDividend)) {
                    int x = restList.get(tmpDividend);
                    result = result.substring(0, x + 1) + "("
                            + result.substring(x + 1) + ")";
                    break;
                }
                restList.put(tmpDividend, aIndex);
            }

            if (aIndex == aMaxIndex + 1) {
                result += ".";
                accPlus = aIndex;
            }

            tmpDividend = tmpDividend * 10
                    + ((aIndex <= aMaxIndex) ? aArray[aIndex] : 0);

            result += tmpDividend / b;

            if (tmpDividend / b != 0) {

                if (columnView.equals("")) {
                    line1 = " "
                            + a
                            + rPad("|", ("" + tmpDividend / b * b).length()
                                    - ("" + a).length() + 1) + b;
                    line2 = "\n" + rPad("-" + tmpDividend / b * b, aIndex + 2)
                            + "|";
                } else {
                    columnView += "\n" + rPad(tmpDividend, aIndex + 2);
                    columnView += "\n"
                            + rPad("-" + tmpDividend / b * b, aIndex + 2);
                }
                columnView += "\n"
                        + rPad(repeatString("-", ("" + tmpDividend).length()),
                                aIndex + 2);
            }

            tmpDividend = tmpDividend % b;
            aIndex++;
        }

        columnView += "\n" + rPad(tmpDividend, aIndex + 1);
        i = 0;
        while (result.charAt(i) == '0') {
            i++;
        }

        result = (result.charAt(i) == '.') ? "0" + result.substring(i) : result
                .substring(i);

        columnView = line1 + line2 + result + columnView;
        return result;
    }

}

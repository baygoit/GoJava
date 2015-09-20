package gojava1.iavorskyi;
 
import java.util.Scanner;
 
public class LongDivider {
 
        private static final int FRACTAL_LENGHT = 10;
        private static final int RADIX = 10;
        private static final String MINUS = "-";
        private static final String SPACE = " ";
        private static final String UNDERSCORE = "---";
        private static final String DOT = ".";
        private static final String OPEN_PARANTHESIS = "(";
        private static final String CLOSE_PARANTHESIS = ")";
       
        public static void main(String[] args) {
 
                Scanner in = new Scanner(System.in);
                System.out.println("This programs divides A/B. Only int numbers permited.");
                System.out.println("Enter A:");
                int dividend = in.nextInt();
                System.out.println("Enter B:");
                int divisor = in.nextInt();
                in.close();
                int[] dividendAsArray = dividendToArray(dividend);
                String result = calculateResult(dividend, divisor, dividendAsArray);
                System.out.println(dividend + " / " + divisor + " = " + result);
               
        }
 
       
        public static String calculateResult(int dividend, int divisor, int[] dividendAsArray) {
                int reminder = 0;
                int part = dividendAsArray[0];
                int[] reminderArray = new int[FRACTAL_LENGHT];
                boolean isPeriod = false;
                boolean isFirst = false;
                String result = "";
 
                System.out.println(SPACE + dividend);
               
                int j = 0;
                while (part < divisor && part != dividend) {
                        part = part * RADIX + dividendAsArray[j + 1];
                        j++;
                }
 
                int tempResult = 0;
                while (j < dividendAsArray.length) {
                        result += part / divisor;
                        if (part / divisor > 0) {
                                tempResult = (part / divisor) * divisor;
                                if (isFirst) {
                                        System.out.println(tab(part, j) + SPACE + part);
                                }
                                System.out.println(tab(tempResult, j) + MINUS + tempResult);
                                System.out.println(tab(tempResult, j) + SPACE + UNDERSCORE);
                        }
                        reminder = part % divisor;
                       
                        if (j == (dividendAsArray.length - 1)) {
                                part = reminder * RADIX;
                        } else {
                                part = reminder * RADIX + dividendAsArray[j + 1];
                        }
                        j++;
                        isFirst = true;
                }
 
                if (reminder != 0) {
                        result += DOT;
                }
 
                int i = 0;
                int fraction = 0;
                int periodIndex = 0;
                while (reminder != 0 && fraction < FRACTAL_LENGHT && !isPeriod) {
                        for (int k = 0; k < reminderArray.length; k++) {
                                if (reminder == reminderArray[k]) {
                                        isPeriod = true;
                                        periodIndex = k - 1;
                                        break;
                                }
                        }
                        if (part / divisor > 0) {
                                tempResult = (part / divisor) * divisor;
                                System.out.println(tab(part, j) + SPACE + part);
                                System.out.println(tab(tempResult, j) + MINUS + tempResult);
                                System.out.println(tab(tempResult, j) + SPACE + UNDERSCORE);
                        }
                        reminderArray[i] = reminder;
                        reminder = part % divisor;
                        if (!isPeriod) {
                                result += part / divisor;
                                part = reminder * RADIX;
                                fraction++;
                                i++;
                                j++;
                        }
                }
                if (isPeriod && reminder != 0) {
                        return formatPeriodResult(periodIndex, result);
                } else {
                        return result;
                }
        }
 
        public static int[] dividendToArray(int dividend) {
                String stringDividend = Integer.toString(dividend);
                int[] dividendAsArray = new int[stringDividend.length()];
                for (int i = 0; i < dividendAsArray.length; i++) {
                        dividendAsArray[i] = Integer.parseInt(Character.toString(stringDividend.charAt(i)));
                }
                return dividendAsArray;
        }
 
        public static String repeatString(String space, int numberOfSpaces) {
                String result = "";
                for (int i = 1; i <= numberOfSpaces; i++) {
                        result += space;
                }
                return result;
        }
       
        public static String tab(int currentNumberToCalculateSpaces, int width) {
                String tab = "";
                int length = Integer.toString(currentNumberToCalculateSpaces).length();
                tab = repeatString(SPACE, width - length);
                return tab;
        }
 
        public static String formatPeriodResult(int index, String result) {
                int dotIndex = result.indexOf(DOT);
                String beforeParenthesis = result.substring(0, index + dotIndex + 2);
                String inParenthesis = result.substring(index + dotIndex + 2, result.length());
                beforeParenthesis += OPEN_PARANTHESIS;
                inParenthesis += CLOSE_PARANTHESIS;
                return beforeParenthesis + inParenthesis;
        }
 
}
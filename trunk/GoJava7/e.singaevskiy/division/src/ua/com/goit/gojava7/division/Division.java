package ua.com.goit.gojava7.division;

import java.util.LinkedList;
import java.util.List;

public class Division {

    private static final int BASE_MULTIPLIER = 10;
    private static final int RESULT_ACCURACY = 11;
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String HORIZONTAL_SEPARATOR = "---";

    public static void printDivision(int divident, int divisor) {

        StringBuilder message = new StringBuilder(divident + VERTICAL_SEPARATOR + divisor + "\n");
        StringBuilder indent = new StringBuilder();
        StringBuilder wholeNumber = new StringBuilder();
        StringBuilder fractionNumber = new StringBuilder();
        List<Integer> remains = new LinkedList<Integer>();

        if (divident < 0 || divisor < 0) {
            divident = Math.abs(divident);
            divisor = Math.abs(divisor);
            wholeNumber.append("-");
        }

        for (int i = 0; i <= RESULT_ACCURACY; i++) {
            int result = divident / divisor;
            int remainder = divident % divisor;
            int currentMinus = divisor * result;

            message.append(indent).append(" ").append(divident).append("\n");
            message.append(indent).append("-").append(currentMinus).append("\n");
            message.append(indent).append(" ").append(HORIZONTAL_SEPARATOR).append("\n");

            indent.append(" ");

            if (i == 0) {
                wholeNumber.append(result);
            } else {
                fractionNumber.append(result);
            }

            if (remainder == 0) {
                break;
            } else if (remains.contains(remainder)) {
                fractionNumber.insert(remains.indexOf(remainder), "(");
                fractionNumber.append(")");
                message.append(indent).append(" ").append(remainder).append("\n");
                break;
            }

            divident = remainder * BASE_MULTIPLIER;
            remains.add(remainder);
        }

        message.append(" = ").append(wholeNumber).append(".").append(fractionNumber);
        System.out.println(message);

    }

}

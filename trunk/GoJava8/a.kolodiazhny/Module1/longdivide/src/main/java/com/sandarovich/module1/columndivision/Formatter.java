package com.sandarovich.module1.columndivision;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Olexander Kolodiazhny 2015
 *
 *         Format String according to task
 */

public class Formatter {

    public String getFirstLine(int dividen, int divider) {

        return Strings.OPERATION_MINUS.toString() + dividen + Strings.SPACE.toString()
                + Strings.COLUMN_DIVIDER.toString() + divider;

    }

    public String getSecondLine(int firstDiff, double result) {

        return Strings.TAB.toString() + firstDiff + Strings.COLUMN_DIVIDER.toString();
    }

    public List<String> getCalculationDeatils(int depth, int dividen, int diff) {

        List<String> result = new ArrayList<>();
        result.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_DIVIDER.toString());
        result.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.SPACE.toString() + (int) dividen);
        result.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_MINUS.toString() + diff);
        return result;
    }

    public List<String> getFooter(int remain, int depth) {

        List<String> result = new ArrayList<>();
        result.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_DIVIDER.toString());
        result.add(StringUtils.repeat(Strings.TAB.toString(), depth) + String.valueOf(remain));
        return result;
    }

    public String formatResult(double calculatedResult, int remain, int depth, int divideDepth) {

        String format = "%." + String.valueOf(divideDepth) + "f";

        if (remain != 0 && depth == divideDepth ) {
            String result = String.format(format, calculatedResult);
            result = result.substring(0, result.indexOf(".") + 1) + Strings.BRACKET_LEFT.toString()
                    + result.substring(result.indexOf(".") + 1, result.length()) + Strings.BRACKET_RIGHT.toString();
            return result;
        }
        return String.format(format, calculatedResult);
    }
}

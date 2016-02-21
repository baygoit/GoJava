package com.sandarovich.module1.columndivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Module #1. Task #4 Column Divide algorithm with text output.
 *
 */

public class ColumnDivision {

    private static final int DIVIDE_DEPTH = 6;
    private static final int GUESS_LIMIT = 10;
    private static final int MULTIPLYER = 10;

    private int dividen;
    private int divider;
    private double result = 0;
    private int remain = -1;
    private int diff;
    private int firstDifference;
    private int depth = 0;
    List<String> calculationDetails;

    public ColumnDivision(int dividen, int divider) {
        this.dividen = dividen;
        this.divider = divider;
        calculationDetails = new ArrayList<String>();
    }

   
    private void addCalculationDetails() {
        Formatter formatter = new Formatter();
        calculationDetails.addAll(formatter.getCalculationDeatils(depth, dividen, diff));
    }

    private void doCalculations() {

        while (depth < DIVIDE_DEPTH) {
            if (dividen <= divider) {
                increaseDividen();
            } else {
                firstDifference = (int) divider * getFactor(dividen, divider);
            }
            int factor = getFactor(dividen, divider);
            result += factor / (Math.pow(MULTIPLYER, depth));
            this.diff = (int) (divider * factor);   
            
            if (!isFirstOperation()) {addCalculationDetails();}
                
            this.remain = (int) (dividen - divider * factor);
            this.dividen = remain;
            
            if (remain == 0) break;           
        }
    }
    
    private void increaseDividen() {
        dividen = dividen * MULTIPLYER;
        depth++;
    }
    
    private boolean isFirstOperation() {
        if (depth == 1 && firstDifference == 0) {
            this.firstDifference = diff;
            return true;
        }
        return false;
    }

    private int getFactor(double dividen, double divider) {
        int result = 0;

        for (int i = GUESS_LIMIT; i >= 1; i--) {
            if (divider * i <= dividen) {
                result = i;
                break;
            }
        }
        return result;
    }
    
    public List<String> getResults() {

        List<String> resultStr = new ArrayList<String>();
        Formatter formatter = new Formatter();

        resultStr.add(formatter.getFirstLine(dividen, divider));
        doCalculations();
        resultStr.addAll(calculationDetails);
        String SecondLine = formatter.getSecondLine(this.firstDifference, this.result)
                + formatter.formatResult(this.result, this.remain, this.depth, DIVIDE_DEPTH);
        resultStr.add(1, SecondLine);
        resultStr.addAll(formatter.getFooter(this.remain, this.depth));
        return resultStr;
    }

}

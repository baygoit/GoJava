package com.sandarovich.module1.numbersdivider;

import org.apache.commons.lang3.StringUtils;

/**
 * Numbers Divider Algorithm
 */

public class NumbersDivider {
    private int dividen;
    private int divider;
    private String chastnoe = "";
    private IO io;

    public NumbersDivider(IO io) {
        this.io = io;
    }


    public void setDividen(int dividen) {
        this.dividen = dividen;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }


    public String calculate() {
        StringBuilder result = new StringBuilder();

        String dividenStr = String.valueOf(dividen);
        String dividerStr = String.valueOf(divider);
        result.append(generateHeader(dividenStr, dividerStr));


        char[] dividenArr = dividenStr.toCharArray();
        String nepolnoeChastnoe = "0";

        int razruadCount = 0;
        for (char number : dividenArr) {
            if (Integer.parseInt(nepolnoeChastnoe) < divider) {
                nepolnoeChastnoe += number;
                razruadCount++;
            } else {
                chastnoe += ".";
            }
        }
        int iteration = 0;
        int factor = Integer.parseInt(nepolnoeChastnoe) / divider;
        int multiplication = factor * divider;
        int ostatok = Integer.parseInt(nepolnoeChastnoe) - multiplication;
        iteration++;

        chastnoe = factor + chastnoe.substring(1, chastnoe.length());


        result.append("\n" + multiplication + Strings.TAB + Strings.COLUMN_DIVIDER + chastnoe);

        result.append("\n" + StringUtils.repeat(Strings.TAB.toString(), iteration)
                + Strings.OPERATION_DIVIDER);


        if (ostatok < divider) {
            nepolnoeChastnoe = ostatok + dividenStr.substring(razruadCount, dividenStr.length());
        }
        result.append("\n" + StringUtils.repeat(Strings.TAB.toString(), iteration)
                + String.valueOf(nepolnoeChastnoe));

        factor = Integer.parseInt(nepolnoeChastnoe) / divider;
        multiplication = factor * divider;
        ostatok = Integer.parseInt(nepolnoeChastnoe) - multiplication;
        iteration++;



        return result.toString();
    }

    private String generateHeader(String dividenStr, String dividerStr) {
        return Strings.OPERATION_MINUS
                + dividenStr
                + Strings.COLUMN_DIVIDER
                + dividerStr;
    }


}

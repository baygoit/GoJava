package com.sandarovich.module1.numbersdivider;

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
        String nepolnoeChastnoe = String.valueOf(dividenArr[0]);

        for (char number : dividenArr) {
            if (Integer.parseInt(nepolnoeChastnoe) < divider) {
                nepolnoeChastnoe += number;
            } else {
                chastnoe += ".";
            }
        }
        result.append("\n" + Strings.COLUMN_DIVIDER + chastnoe);


        return result.toString();
    }

    private String generateHeader(String dividenStr, String dividerStr) {
        return dividenStr
                + Strings.COLUMN_DIVIDER
                + dividerStr;
    }


}

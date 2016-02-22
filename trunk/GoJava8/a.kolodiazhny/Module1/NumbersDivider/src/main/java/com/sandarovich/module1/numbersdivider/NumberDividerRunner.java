package com.sandarovich.module1.numbersdivider;

/**
 * Runner for NumberDivider algorithm
 */

public class NumberDividerRunner {
    private static IO io;

    public static void main(String[] args) {
        io = new ConsoleIO();
        io.write(getIntro());
        NumbersDivider numberDivider = new NumbersDivider(io);
        numberDivider.setDividen(initializeValue("dividen"));
        numberDivider.setDivider(initializeValue("divider"));
        io.write(numberDivider.calculate());

    }

    private static int initializeValue(String label) {
        int result;
        try {
            io.write("Please enter " + label + ":");
            result = io.parse(io.read());
        } catch (Exception e) {
            result = initializeValue(label);
        }
        return result;
    }

    private static String getIntro() {
        return "============================== \n" +
                "Number Dividen Application \n" +
                "by Olexander Kolodiazhny 2016 \n" +
                "==============================";
    }


}

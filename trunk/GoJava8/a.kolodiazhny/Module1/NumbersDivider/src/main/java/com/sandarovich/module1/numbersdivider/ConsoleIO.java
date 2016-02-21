package com.sandarovich.module1.numbersdivider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console implementation
 */
public class ConsoleIO implements IO {
    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        String result = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = reader.readLine();
        } catch (IOException exception) {
            new ConsoleIO().write(">> Exception.Unable to read input");
        }
        return result;
    }

    @Override
    public int parse(String value) {
        int result;
        try {
            result = Integer.parseInt(value);
            if (result < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException exception) {
            new ConsoleIO().write(">> Positive numbers only is acceptable");
            throw exception;
        }
        return result;
    }


}

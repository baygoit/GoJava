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
    public int[] read() {
        int[] result = new int[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = reader.readLine();
        } catch (IOException e) {
            new ConsoleIO().write(">> Exception.Unable to read input");
        }
        return result;
    }


}

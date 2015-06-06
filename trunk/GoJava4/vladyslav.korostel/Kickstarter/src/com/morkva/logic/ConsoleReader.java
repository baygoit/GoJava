package com.morkva.logic;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by vladyslav on 11.05.15.
 */
public class ConsoleReader implements Reader {

    public ConsoleReader() {
    }

    @Override
    public int readUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        try {
            userInput = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Please Enter only numbers");
            userInput = readUserInput();
        }
        return userInput;
    }
}

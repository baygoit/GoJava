package com.morkva.logic;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by vladyslav on 11.05.15.
 */
public class ConsoleReader implements Reader {

    Printer printer;

    public ConsoleReader(Printer printer) {
        this.printer = printer;
    }

    @Override
    public int readUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        try {
            userInput = scanner.nextInt();
        } catch (InputMismatchException e) {
            printer.print("Please enter only numbers!" + "\n");
            userInput = readUserInput();
        }
        return userInput;
    }
}

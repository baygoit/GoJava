package com.tyomsky.kickstarter.ui;

import com.tyomsky.kickstarter.mvc.controller.InputListener;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Input, Output {

    private InputListener inputListener;

    private int getIntFromUser() {
        int result = 0;
        System.out.println("Make a choice:");
        Scanner scanner = new Scanner(System.in);
        try {
            result = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("You entered not a number. Try Again.");
            getIntFromUser();
        }
        return result;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    @Override
    public void listenInput() {

        while (true) {
            inputListener.onInput(getIntFromUser());
        }
    }

    @Override
    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }
}

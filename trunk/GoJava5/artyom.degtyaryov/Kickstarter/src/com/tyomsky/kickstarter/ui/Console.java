package com.tyomsky.kickstarter.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Input, Output {

    private int userChoice;

    public int getNotValidatedUserChoice() {
        getIntFromUser();
        return userChoice;
    }


    private void getIntFromUser() {
        System.out.println("Make a choice:");
        Scanner scanner = new Scanner(System.in);
        try {
            userChoice = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("You entered not a number. Try Again.");
            getIntFromUser();
        }
    }

    private void validateUserChoice(int variants) {
        if (userChoice < 0 || userChoice > (variants - 1)) {
            System.out.println("There no such variant. Try Again.");
            getIntFromUser();
            validateUserChoice(variants);
        }
    }

    @Override
    public int getUserChoice() {
        getIntFromUser();
//        validateUserChoice(variants);
        return userChoice;
    }

    @Override
    public void print(ArrayList<String> view) {
        clearConsole();
        for (String string : view) {
            System.out.println(string);
        }

    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n");
    }

}

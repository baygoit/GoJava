package com.tyomsky.kickstarter.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Input, Output {

    private int userChoise;

    public int getNotValidatedUserChois() {
        getIntFromUser();
        return userChoise;
    }


    private void getIntFromUser() {
        System.out.println("Make a choise:");
        Scanner scaner = new Scanner(System.in);
        try {
            userChoise = scaner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("You entered not a number. Try Again.");
            getIntFromUser();
        }
    }

    private void validateUserChoise(int variants) {
        if (userChoise < 0 || userChoise > (variants - 1)) {
            System.out.println("There no such variant. Try Again.");
            getIntFromUser();
            validateUserChoise(variants);
        }
    }

    @Override
    public int getUserChoice(int variants) {
        getIntFromUser();
        validateUserChoise(variants);
        return userChoise;
    }

    @Override
    public void print(ArrayList<String> view) {
        clearConsole();
        for (String string : view) {
            System.out.println(string);
        }

    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n");
    }

}

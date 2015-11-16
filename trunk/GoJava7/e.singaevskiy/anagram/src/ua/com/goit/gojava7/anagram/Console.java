package ua.com.goit.gojava7.anagram;

import java.util.Scanner;

public class Console {

    private Scanner inputReader;

    private static final String WELCOME_MESSAGE = "Input phrase or sentence";

    public Console() {

        this.inputReader = new Scanner(System.in);

    }

    public void close() {
        this.inputReader.close();
    }

    public String getUserInput() {
        System.out.println(WELCOME_MESSAGE);
        return this.inputReader.nextLine();
    }

}

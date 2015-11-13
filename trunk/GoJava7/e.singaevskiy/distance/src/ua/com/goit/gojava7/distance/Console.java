package ua.com.goit.gojava7.distance;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

    private String userInput;
    private Scanner inputReader;

    private static final String WELCOME_MESSAGE = "Input line of integers, separated with spaces";
    private static final String DELIMITER = " ";
    private static final String PARSE_MESSAGE = "Input line parsed: ";

    public Console() {

        this.userInput = "";
        this.inputReader = new Scanner(System.in);

    }

    public void readUserInput() {

        System.out.println(WELCOME_MESSAGE);
        this.userInput = this.inputReader.nextLine();

    }

    public int[] parseUserInput() {

        String[] numbers = this.userInput.split(DELIMITER);
        int[] rezult = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            rezult[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println(PARSE_MESSAGE + Arrays.toString(rezult));
        return rezult;

    }

    public void close() {

        this.inputReader.close();
        this.userInput = "";

    }

}

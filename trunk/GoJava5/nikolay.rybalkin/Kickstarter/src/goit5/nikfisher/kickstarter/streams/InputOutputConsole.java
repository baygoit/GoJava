package goit5.nikfisher.kickstarter.streams;


import java.util.Scanner;

public class InputOutputConsole implements InputOutputConsoleInterface{


    @Override
    public String consoleScanString() {
        Scanner scaner = new Scanner(System.in);
        return scaner.next();
    }

    @Override
    public int consoleScanInt() {
        Scanner scaner = new Scanner(System.in);
        int number = 0;
        try {
            scaner.hasNextInt();
            number = scaner.nextInt();
        } catch (Exception e) {
            System.out.println("You entered is not a number!");
        }
        return number;
    }

    @Override
    public void println(String result) {
        System.out.println(result);
    }

    @Override
    public void print(String result) {
        System.out.println(result);
    }
}

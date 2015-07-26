package goit5.nikfisher.kickstarter.streams;


import java.util.Scanner;

public class ConsoleIO implements ConsoleInterfaceIO {

    private Scanner scaner = new Scanner(System.in);

    @Override
    public String consoleScanString() {
        return scaner.next();
    }

    @Override
    public int consoleScanInt() {
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

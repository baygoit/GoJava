package goit5.nikfisher.kickstarter.streams;


import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleIO implements ConsoleInterfaceIO {

    private static final Logger log = Logger.getLogger(String.valueOf(ConsoleIO.class));

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
            log.warning("You entered is not a number!");
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

package nikfisher.kickstarter.streams;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsoleIO implements ConsoleInterfaceIO {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsoleIO.class);
    final private Scanner SCANNER = new Scanner(System.in);

    @Override
    public String consoleScanString() {
        return SCANNER.next();
    }

    @Override
    public int consoleScanInt() {
        int number = 0;
        try {
            SCANNER.hasNextInt();
            number = SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println("You entered is not a number!");
            LOGGER.error("You entered is not a number!");
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

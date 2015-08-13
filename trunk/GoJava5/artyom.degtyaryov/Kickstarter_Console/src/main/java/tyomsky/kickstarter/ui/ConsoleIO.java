package tyomsky.kickstarter.ui;

import java.util.Scanner;

public class ConsoleIO implements Input, Output {

    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

}

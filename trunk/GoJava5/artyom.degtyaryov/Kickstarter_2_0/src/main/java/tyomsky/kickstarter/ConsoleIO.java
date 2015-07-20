package tyomsky.kickstarter;

import java.util.Scanner;

public class ConsoleIO implements IO {

    @Override
    public int read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

}

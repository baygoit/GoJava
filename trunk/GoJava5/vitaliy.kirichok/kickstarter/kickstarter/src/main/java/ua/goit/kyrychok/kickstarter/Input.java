package ua.goit.kyrychok.kickstarter;

import java.util.Scanner;

public class Input {
    private InputListener inputListener;
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public void addListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public String getLine() {
        return scanner.nextLine();
    }

    public void listenInput() {
        try {
            while (scanner.hasNextLine()) {
                inputListener.onInput(scanner.nextLine());
            }
        } catch (IllegalStateException e) {
            close();
        }
    }
}

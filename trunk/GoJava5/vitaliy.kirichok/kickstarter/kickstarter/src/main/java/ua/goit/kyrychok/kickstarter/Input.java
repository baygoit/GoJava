package ua.goit.kyrychok.kickstarter;

import java.util.Scanner;

public class Input {
    private InputListener inputListener;

    public Input(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void listenInput() {
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        while (result) {
            result = inputListener.onInput(scanner.next());
        }
        scanner.close();
    }
}

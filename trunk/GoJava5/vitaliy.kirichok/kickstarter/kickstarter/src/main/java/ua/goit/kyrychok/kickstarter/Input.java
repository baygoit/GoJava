package ua.goit.kyrychok.kickstarter;

import java.util.Scanner;

public class Input {
    private InputListener inputListener;

    public Input(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void listenInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                inputListener.onInput(scanner.nextLine());
            }
            scanner.close();
        } catch (EmptyDispatcherException e) {
            scanner.close();
        }
    }
}

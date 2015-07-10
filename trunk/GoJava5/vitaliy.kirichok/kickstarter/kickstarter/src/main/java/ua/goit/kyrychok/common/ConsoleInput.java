package ua.goit.kyrychok.common;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner;

    @Override
    public void init() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int getNext() {
        return scanner.nextInt();
    }

    @Override
    public void close() {
        scanner.close();
    }
}

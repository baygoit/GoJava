package org.kudryavtsev.kickstarter.in;

import java.util.Scanner;

public class InConsole implements In {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int input() {
        System.out.println("You choice (0 - exit):");
        int answer = 0;
        answer = scanner.nextInt();
        return answer;
    }

    public void close() {
        scanner.close();
    }
}

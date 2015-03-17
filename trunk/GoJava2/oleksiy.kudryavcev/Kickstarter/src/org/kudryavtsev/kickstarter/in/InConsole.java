package org.kudryavtsev.kickstarter.in;

import java.util.Scanner;

public class InConsole implements In {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int input() {
        int answer = 0;
        if (scanner.hasNextInt()) {
            answer = scanner.nextInt();
        }
        return answer;
    }

    public void close() {
        scanner.close();
    }
}

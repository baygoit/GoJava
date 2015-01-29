package org.kudryavtsev.kickstarter;

import java.util.Scanner;

public class Scan {
    private Scanner in = new Scanner(System.in);

    public int getAnswer() {
        System.out.print("You choice (0 - exit):");
        int answer = 0;
        answer = in.nextInt();
        return answer;
    }

    public void close() {
        in.close();
    }
}

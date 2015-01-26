package org.kudryavtsev.kickstarter;

import java.util.Scanner;

public class Scan {
    private Scanner in = new Scanner(System.in);

    public int getAnswer() {
//        Scanner in = new Scanner(System.in);
        System.out.print("You choice: ");
        int answer = 0;
        // if (in.hasNextInt()) {
        answer = in.nextInt();
        // }
        // close();

        return answer;
    }

    public void close() {
        in.close();
    }

}

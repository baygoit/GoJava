package org.kudryavtsev.kickstarter;

import java.util.Scanner;

public class Scan {
    public int getAnswer() {
        Scanner in = new Scanner(System.in);
        System.out.print("You choice: ");
        int answer = in.nextInt();
        in.close();
        return answer;
    }
}

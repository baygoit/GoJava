package org.kudryavtsev.kickstarter;

import java.util.Scanner;

public class InConsole implements In {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public int input() {
        System.out.print("You choice (0 - exit):");
        int answer = 0;
//        try {
            answer = scanner.nextInt();
//        } catch (Exception e) {
//            // TODO: handle exception
//            return ;
//        } // finally {
        // System.err.print(" 3");
        // }
        return answer;
    }
    public void close() {
        scanner.close();
    }
}

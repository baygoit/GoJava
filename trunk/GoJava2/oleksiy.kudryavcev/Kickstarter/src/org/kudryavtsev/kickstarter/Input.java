package org.kudryavtsev.kickstarter;

import java.util.Scanner;

public class Input {
    private In in;
    
    public Input (In input){
        in = input;
    }
    
    public int getAnswer() {
        return in.input();
    }

    public void close() {
        in.close();
    }
}

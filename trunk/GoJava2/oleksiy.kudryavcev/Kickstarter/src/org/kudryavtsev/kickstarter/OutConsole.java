package org.kudryavtsev.kickstarter;

public class OutConsole implements Out {

    @Override
    public void output(String output) {
        System.out.println(output);
    }
}

package org.kudryavtsev.kickstarter.out;

public class OutConsole implements Out {

    @Override
    public void output(String output) {
        System.out.println(output);
    }

    @Override
    public void close() {
    }
}

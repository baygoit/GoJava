package org.kudryavtsev.kickstarter.inout;

import java.util.ArrayList;

public class OutArrayList implements Out {
    private ArrayList<String> list;

    public OutArrayList() {
        list = new ArrayList<String>();
    }

    @Override
    public void output(String output) {
        list.add(output);
        printAll();
//        list.clear();
    }

    public String print() {
        return list.remove(0);
    }

    public void printAll() {
        System.out.println(this.print());
    }
}

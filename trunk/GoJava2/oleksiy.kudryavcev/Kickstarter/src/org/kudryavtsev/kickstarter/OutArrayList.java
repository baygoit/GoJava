package org.kudryavtsev.kickstarter;

import java.util.ArrayList;

public class OutArrayList implements Out {
    private ArrayList<String> list;

    public OutArrayList() {
        list = new ArrayList<String>();
    }

    @Override
    public void output(String output) {
        list.add(output);
        System.out.println(this.print());
    }
    
    public String print() {
        return list.remove(0);
    }
}

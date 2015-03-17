package org.kudryavtsev.kickstarter.out;

import java.util.ArrayList;
import java.util.List;

public class OutArrayList implements Out {
    private ArrayList<String> list;

    public OutArrayList() {
        list = new ArrayList<String>();
    }

    @Override
    public void output(String output) {
        list.add(output);
    }

    public String print() {
        return list.remove(0);
    }

    public List<String> getAll() {
        return list;
    }

    @Override
    public void close() {
    }
}

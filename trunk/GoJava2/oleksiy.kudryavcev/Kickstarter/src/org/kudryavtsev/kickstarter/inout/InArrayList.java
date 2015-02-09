package org.kudryavtsev.kickstarter.inout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InArrayList implements In {
    private List<Integer> list;

    public InArrayList() {
        list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 1, 0, 2, 0, 0, 2, 1, 0, 2, 0, 0, 3, 1, 0, 2, 0, 0, 0);
    }

    @Override
    public int input() {
        System.out.println(list.get(0));
        return list.remove(0);
    }

    @Override
    public void close() {
    }
}

package org.kudryavtsev.kickstarter.in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class InArrayList implements In {
    private List<Integer> list;

    public InArrayList(Integer... menus) {
        list = new ArrayList(Arrays.asList(menus));
    }

    @Override
    public int input() {
        return list.remove(0);
    }

    @Override
    public void close() {
    }
}

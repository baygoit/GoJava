package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.mvc.controller.InputListener;

import java.util.ArrayList;

public class Dispatcher implements InputListener {

    private ArrayList<Integer> path = new ArrayList<>();

    @Override
    public void onInput(int input) {
        boolean wasUpdated = updatePath(input);



    }

    private boolean updatePath(int intInput) {
        if (intInput != 0) {
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i) == 0) {
                    path.add(i, intInput);
                    return true;
                }
            }
        } else {
            for (int i = path.size() - 1; i <= 0; i--) {
//                if (path[i] != 0) {
//                    path[i] = intInput;
//                    return true;
//                }
            }
        }
        return false;
    }
}
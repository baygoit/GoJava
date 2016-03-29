package com.vladik;

import java.util.List;

public class AnagramSolver {

    public List<String> flipWords(List<String> listOfStr) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < listOfStr.size(); i++) {
            strBuilder.append(listOfStr.get(i));
            strBuilder.reverse();
            listOfStr.set(i, strBuilder.toString());
            strBuilder.setLength(0);
        }
        return listOfStr;
    }
}

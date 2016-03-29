package com.vladik;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        List<String> stringList = reader.getListOfStr();
        AnagramSolver anagramSolver = new AnagramSolver();
        System.out.println(anagramSolver.flipWords(stringList));
    }
}

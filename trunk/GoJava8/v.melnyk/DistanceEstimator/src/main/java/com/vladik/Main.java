package com.vladik;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        String[] inputPieces = reader.readUserNumbersLine().split(" ");
        List<Integer> inputList = reader.parseUserNumbersLine(inputPieces);
        DistanceCalculator distanceCalculator = new DistanceCalculator(inputList);
        System.out.println("Initial inputs: " + inputList);
        System.out.println("Distance between the minimum inputs: " + distanceCalculator.findDistanceBetweenTwoMinimumInputs());
    }
}

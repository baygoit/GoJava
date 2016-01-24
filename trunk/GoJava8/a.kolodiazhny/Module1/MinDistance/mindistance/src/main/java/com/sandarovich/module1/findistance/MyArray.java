package com.sandarovich.module1.findistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.hamcrest.core.SubstringMatcher;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 *         Custom Array List for task #2.
 *
 */

public class MyArray {

    private List<Integer> array;
    private List<Integer> sortedArray;

    public MyArray(int[] inputArray) {
        array = new ArrayList<Integer>();
        for (int i : inputArray) {
            array.add(i);
        }

        sortedArray = new ArrayList<Integer>(this.array);
    }

    private void sort() {
        Collections.sort(sortedArray);

    }

    private int getElementCount(int element) {
        if (array.contains(element)) {
            return Collections.frequency(array, element);
        }
        return 0;
    }

    private int getElementIndex(int element) {
        return array.indexOf(element);
    }

    private ArrayList<Integer> getMinElementIndexes(int minElement) {

        ArrayList<Integer> minIndexes = new ArrayList<Integer>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == minElement) {
                minIndexes.add(i);
            }
        }

        return minIndexes;
    }

    private String getDistanceBetweenTwoElement(int firstMin, int secondMin) {
        int out = Math.abs(getElementIndex(firstMin) - getElementIndex(secondMin));
        return String.valueOf(out);
    }

    private List<Integer> getDistanceBetweenSameElement(int firstMin) {
        ArrayList<Integer> out = new ArrayList<>();
        ArrayList<Integer> indexesOfMin = getMinElementIndexes(firstMin);

        for (int i = 0; i <= indexesOfMin.size(); i++) {
            for (int j = i + 1; j < indexesOfMin.size(); j++) {
                int firstIndex = indexesOfMin.get(i);
                int secondIndex = indexesOfMin.get(j);
                out.add(Math.abs(firstIndex - secondIndex));
            }
        }

        return out;
    }

    private String distancesToString(List<Integer> distances) {
        String out = "";

        for (int elem : distances) {
            out += elem + ", ";
        }
        return out.substring(0, out.length() - 2);

    }

    // TODO O.Kolodiazhny. MAYBE PATTERN STRATEGY??? Not sure.

    public String getDistance() {
        sort();
        if (getElementCount(sortedArray.get(0)) >= 2) {
            return distancesToString(getDistanceBetweenSameElement(sortedArray.get(0)));
        }
        if (getElementCount(sortedArray.get(0)) == 1) {
            return getDistanceBetweenTwoElement(sortedArray.get(0), sortedArray.get(1));
        }
        return "-1";
    }
}

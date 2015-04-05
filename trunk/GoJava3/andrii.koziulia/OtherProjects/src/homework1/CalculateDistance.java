package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by Alex on 14.03.2015.
 */

/*
Input: 3 12 3 4 5 2 8 7 12
Output: 3

Input: 1 1 1 12 3 4 5 17 8 2 7 1
Output: 1

Input: 1 2 2 1 2 1
Output: 2

Input: 1 2 1 2 2 1
Output: 2

Input: 2 9 3 3 3 11 15
Output: 2

Input: 2 5 8 7 2 2 3 1
Output: 2

Input: 2 5 8 7 2 2 3 1 0
Output: 1
 */

public class CalculateDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayStr = reader.readLine().split(" ");
        int[] array = new int[arrayStr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        int min = array[0];
        int secondMin = array[1];
        int indexMin = 0;
        int indexSecondMin = 1;
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                if (secondMin < min) {
                    secondMin = min;
                    indexSecondMin = indexMin;
                }
                if (secondMin > min) {
                    secondMin = min;
                    indexSecondMin = indexMin;
                }
                min = array[i];
                indexMin = i;
                set.clear();
            } else if (array[i] < secondMin) {
                secondMin = array[i];
                set.clear();
            }
            if (array[i] == secondMin && array[i] == min) {
                indexSecondMin = i;
                set.add(indexSecondMin - indexMin);
                indexMin = i;
            } else if (array[i] == min) {
                indexMin = i;
                set.add(indexMin - indexSecondMin);
            } else if (array[i] == secondMin) {
                indexSecondMin = i;
                set.add(indexSecondMin - indexMin);
            }
        }
        System.out.println(set.first());
    }
}

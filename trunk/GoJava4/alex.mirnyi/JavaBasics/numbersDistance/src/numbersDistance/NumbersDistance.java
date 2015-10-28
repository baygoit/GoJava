package numbersDistance;

import java.io.*;
import java.util.*;

public class NumbersDistance {
    
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        int[][] minNumbersAndPosition = new int[2][2];
        int[] minNumbersPosition = new int[2];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers:");
        String name = in.nextLine();
        
        String[] arrayString = name.split(" ");
        list.add(Integer.valueOf(arrayString[0]));
        list.add(Integer.valueOf(arrayString[1]));
        minNumbersAndPosition = firstTwoArrayElements(list);

        for ( int i = 2; i < arrayString.length; i++ ) {
            list.add(Integer.valueOf(arrayString[i]));
            
            if ( list.get(i) < minNumbersAndPosition[0][0] ) {
                minNumbersAndPosition[1][0] = minNumbersAndPosition[0][0];
                minNumbersAndPosition[1][1] = minNumbersAndPosition[0][1];
                minNumbersAndPosition[0][0] = list.get(i);
                minNumbersAndPosition[0][1] = i;
            } else if ( list.get(i) < minNumbersAndPosition[1][0] ) {
                minNumbersAndPosition[1][0] = list.get(i);
                minNumbersAndPosition[1][1] = i;
            }
        }
//        System.out.println(minNumbersAndPosition[0][1].type());
        System.out.println(Math.abs(minNumbersAndPosition[0][1] - minNumbersAndPosition[1][1]));   
    }


    public static int[][] firstTwoArrayElements(List<Integer> list) {
        int[][] minNumbersAndPosition = new int[2][2];
        if ( list.get(0) <= list.get(1) ) {
            minNumbersAndPosition[0][0] = list.get(0);
            minNumbersAndPosition[0][1] = 0;
            minNumbersAndPosition[1][0] = list.get(1);
            minNumbersAndPosition[1][1] = 1;
        } else {
            minNumbersAndPosition[0][0] = list.get(1);
            minNumbersAndPosition[0][1] = 1;
            minNumbersAndPosition[1][0] = list.get(0);
            minNumbersAndPosition[1][1] = 0;
        }
        return minNumbersAndPosition;
    }

    public static int[][] otherArrayElements(Integer list) {
        int[][] minNumbersAndPosition = new int[2][2];
        if ( list < minNumbersAndPosition[0][0] ) {
            minNumbersAndPosition[1][0] = minNumbersAndPosition[0][0];
            minNumbersAndPosition[1][1] = minNumbersAndPosition[0][1];
            minNumbersAndPosition[0][0] = list;
            minNumbersAndPosition[0][1] = i;
        } else if ( list < minNumbersAndPosition[1][0] ) {
            minNumbersAndPosition[1][0] = list;
            minNumbersAndPosition[1][1] = i;
        }
        return minNumbersAndPosition;
    }

}

